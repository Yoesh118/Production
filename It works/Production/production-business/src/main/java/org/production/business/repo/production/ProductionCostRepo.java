/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductionCostRepo extends AbstractRepo<ProductionCost, String> {

    @Override
    public List<ProductionCost> findAll();

    public List<ProductionCost> findByActiveOrderByNameAsc(Boolean active);

    @Query("from ProductionCost e  where  e.active=:active and (e.name Like :name%  or e.productionCostId Like :name%) order by e.name ASC")
    public List<ProductionCost> findByName(@Param("name") String name, @Param("active") Boolean active);
}
