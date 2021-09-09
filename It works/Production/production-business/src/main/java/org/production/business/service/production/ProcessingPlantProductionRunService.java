/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantProductionRun;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProcessingPlantProductionRunService extends AbstractProcessingPlantAttrService<ProcessingPlantProductionRun> {

    public List<ProcessingPlantProductionRun> findByActiveOrderByProcessingPlantProductionRunNo(Boolean active);

    public List<ProcessingPlantProductionRun> search(SearchByNameDTO dto);
    
     public List<ProcessingPlantProductionRun> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantProductionRunNo);

}
