/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose IncidentCost | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.IncidentCost;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface IncidentCostService extends AbstractProductionCostAttrService<IncidentCost> {

    public List<IncidentCost> findByActiveOrderByCompanyDetails(Boolean active);

    public List<IncidentCost> search(SearchByNameDTO dto);

    public List<IncidentCost> getByProductionCost(ProductionCost productionCost, String companyDetails);

}
