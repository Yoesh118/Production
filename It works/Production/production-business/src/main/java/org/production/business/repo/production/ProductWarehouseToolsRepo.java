/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProductWarehouseTools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseTools;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductWarehouseToolsRepo extends AbstractProductWarehouseAttrRepo<ProductWarehouseTools, String> {

    @Override
    public List<ProductWarehouseTools> findAll();

    public List<ProductWarehouseTools> findByActiveOrderByProductWarehouseToolNoAsc(Boolean active);

    @Query("from ProductWarehouseTools pt left join fetch pt.productWarehouse where pt.productWarehouse=:productWarehouse and pt.productWarehouseToolNo=:productWarehouseToolNo")
    public List<ProductWarehouseTools> findByProductWarehouseToolNo(@Param("productWarehouse") ProductWarehouse productWarehouse, @Param("productWarehouseToolNo") String productWarehouseToolNo);

}
