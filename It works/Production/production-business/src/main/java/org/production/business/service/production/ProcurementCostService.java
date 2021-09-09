/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProcurementCost | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.ProcurementCost;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProcurementCostService extends AbstractProductionCostAttrService<ProcurementCost> {

    public List<ProcurementCost> findByActiveOrderByItem(Boolean active);

    public List<ProcurementCost> search(SearchByNameDTO dto);

    public List<ProcurementCost> getByProductionCost(ProductionCost productionCost, String item);

}
