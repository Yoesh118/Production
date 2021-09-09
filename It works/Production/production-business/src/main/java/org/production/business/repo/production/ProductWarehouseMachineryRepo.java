/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseMachinery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehouseMachineryRepo extends AbstractProductWarehouseAttrRepo<ProductWarehouseMachinery, String> {

    @Override
    public List<ProductWarehouseMachinery> findAll();

    public List<ProductWarehouseMachinery> findByActiveOrderByProductWarehouseMachineryNameAsc(Boolean active);

  
     @Query("from ProductWarehouseMachinery pp left join fetch pp.productWarehouse where pp.productWarehouse=:productWarehouse and pp.productWarehouseMachineryNo=:productWarehouseMachineryNo")
    public List<ProductWarehouseMachinery> findByProductWarehouseMachineryName(@Param("productWarehouse") ProductWarehouse productWarehouse, @Param("productWarehouseMachineryNo") String productWarehouseMachineryNo);



}
