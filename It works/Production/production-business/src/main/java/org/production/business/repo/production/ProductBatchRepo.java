/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductBatch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductBatchRepo extends AbstractRepo<ProductBatch, String> {

    @Override
    public List<ProductBatch> findAll();

    public List<ProductBatch> findByActiveOrderByProductBatchNameAsc(Boolean active);

    @Query("from ProductBatch e  where  e.active=:active and (e.productBatchName Like :productBatchName%) order by e.productBatchId ASC")
    public List<ProductBatch> findByProductBatchName(@Param("productBatchName") String productBatchName, @Param("active") Boolean active);
}
