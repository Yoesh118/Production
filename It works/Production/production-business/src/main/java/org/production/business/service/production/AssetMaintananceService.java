/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import org.production.business.service.*;
import java.util.List;
import org.production.business.domain.production.AssetMaintanance;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface AssetMaintananceService extends GenericService<AssetMaintanance> {

    public List<AssetMaintanance> findByActiveOrderByAssetMaintananceProduct(Boolean active);
    public List<AssetMaintanance> search(SearchByNameDTO dto);
}
