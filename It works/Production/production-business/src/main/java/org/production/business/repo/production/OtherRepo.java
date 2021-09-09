/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Other | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.Other;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface OtherRepo extends AbstractProductionCostAttrRepo<Other, String> {

    @Override
    public List<Other> findAll();

    public List<Other> findByActiveOrderByNameAsc(Boolean active);

    @Query("from Other o left join fetch o.productionCost where o.productionCost=:productionCost and o.name=:name")
    public List<Other> findByName(@Param("productionCost") ProductionCost productionCost, @Param("name") String name);

}
