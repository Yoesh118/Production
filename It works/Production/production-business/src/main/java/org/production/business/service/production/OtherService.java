/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Other | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.Other;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface OtherService extends AbstractProductionCostAttrService<Other> {

    public List<Other> findByActiveOrderByName(Boolean active);

    public List<Other> search(SearchByNameDTO dto);

    public List<Other> getByProductionCost(ProductionCost productionCost, String name);

}
