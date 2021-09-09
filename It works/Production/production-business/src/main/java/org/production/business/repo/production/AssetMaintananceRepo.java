/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.AssetMaintanance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface AssetMaintananceRepo extends AbstractRepo<AssetMaintanance, String> {

    @Override
    public List<AssetMaintanance> findAll();

    public List<AssetMaintanance> findByActiveOrderByAssetMaintananceProductAsc(Boolean active);

    @Query("from AssetMaintanance e  where  e.active=:active and (e.assetMaintananceProduct Like :assetMaintananceProduct%  or e.assetMaintananceDescription Like :assetMaintananceProduct%) order by e.assetMaintananceProduct ASC")
    public List<AssetMaintanance> findByAssetMaintananceProduct(@Param("assetMaintananceProduct") String assetMaintananceProduct, @Param("active") Boolean active);
}
