/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehousePos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehousePosRepo extends AbstractProductWarehouseAttrRepo<ProductWarehousePos, String> {

    @Override
    public List<ProductWarehousePos> findAll();

    public List<ProductWarehousePos> findByActiveOrderByProductWarehousePosNoAsc(Boolean active);
    
    @Query("from ProductWarehousePos wp left join fetch wp.productWarehouse where wp.productWarehouse=:productWarehouse and wp.orderNo=:orderNo")
    public List<ProductWarehousePos> findByProductWarehousePosNo(@Param("productWarehouse") ProductWarehouse productWarehouse, @Param("orderNo") String orderNo);

}
