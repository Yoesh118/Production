/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import org.production.business.service.*;
import java.util.List;
import org.production.business.domain.production.ProductionRun;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProductionRunService extends GenericService<ProductionRun> {

    public List<ProductionRun> findByActiveOrderByProductionRunDescription(Boolean active);

    public List<ProductionRun> search(SearchByNameDTO dto);

}
