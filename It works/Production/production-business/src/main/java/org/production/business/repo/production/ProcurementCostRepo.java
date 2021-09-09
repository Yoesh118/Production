/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProcurementCosts | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.ProcurementCost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcurementCostRepo extends AbstractProductionCostAttrRepo<ProcurementCost, String> {

    @Override
    public List<ProcurementCost> findAll();

    public List<ProcurementCost> findByActiveOrderByItemAsc(Boolean active);

    @Query("from ProcurementCost pc left join fetch pc.productionCost where pc.productionCost=:productionCost and pc.item=:item")
    public List<ProcurementCost> findByItem(@Param("productionCost") ProductionCost productionCost, @Param("item") String item);

}
