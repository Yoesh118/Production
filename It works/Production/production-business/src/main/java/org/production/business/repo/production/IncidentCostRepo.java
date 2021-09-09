/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose IncidentCost | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.IncidentCost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface IncidentCostRepo extends AbstractProductionCostAttrRepo<IncidentCost, String> {

    @Override
    public List<IncidentCost> findAll();

    public List<IncidentCost> findByActiveOrderByCompanyDetailsAsc(Boolean active);

    @Query("from IncidentCost ic left join fetch ic.productionCost where ic.productionCost=:productionCost and ic.companyDetails=:companyDetails")
    public List<IncidentCost> findByCompanyDetails(@Param("productionCost") ProductionCost productionCost, @Param("companyDetails") String companyDetails);

}
