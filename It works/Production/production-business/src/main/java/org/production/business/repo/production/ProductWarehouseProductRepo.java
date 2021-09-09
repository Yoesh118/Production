/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehouseProductRepo extends AbstractProductWarehouseAttrRepo<ProductWarehouseProduct, String> {

    @Override
    public List<ProductWarehouseProduct> findAll();

    public List<ProductWarehouseProduct> findByActiveOrderByProductWarehouseProductNoAsc(Boolean active);

     @Query("from ProductWarehouseProduct wp left join fetch wp.productWarehouse where wp.productWarehouse=:productWarehouse and wp.productWarehouseProductNo=:productWarehouseProductNo")
    public List<ProductWarehouseProduct> findByProductWarehouseProductNo(@Param("productWarehouse") ProductWarehouse productWarehouse, @Param("productWarehouseProductNo") String productWarehouseProductNo);

}
