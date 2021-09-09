/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.FinishedProducts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface FinishedProductsRepo extends AbstractRepo<FinishedProducts, String> {

    @Override
    public List<FinishedProducts> findAll();

    public List<FinishedProducts> findByActiveOrderByFinishedProductsIdAsc(Boolean active);

    @Query("from FinishedProducts e  where  e.active=:active and (e.finishedProductsId Like :finishedProductsId%) order by e.finishedProductsId ASC")
    public List<FinishedProducts> findByFinishedProductsId(@Param("finishedProductsId") String finishedProductsId, @Param("active") Boolean active);
}
