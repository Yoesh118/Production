/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseProductionTeam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehouseProductionTeamRepo extends AbstractProductWarehouseAttrRepo<ProductWarehouseProductionTeam, String> {

    @Override
    public List<ProductWarehouseProductionTeam> findAll();

    public List<ProductWarehouseProductionTeam> findByActiveOrderByProductWarehouseProductionTeamNoAsc(Boolean active);

    @Query("from ProductWarehouseProductionTeam pt left join fetch pt.productWarehouse where pt.productWarehouse=:productWarehouse and pt.productWarehouseProductionTeamNo=:productWarehouseProductionTeamNo")
    public List<ProductWarehouseProductionTeam> findByProductWarehouseProductionTeamNo(@Param("productWarehouse") ProductWarehouse productWarehouse, @Param("productWarehouseProductionTeamNo") String productWarehouseProductionTeamNo);

}
