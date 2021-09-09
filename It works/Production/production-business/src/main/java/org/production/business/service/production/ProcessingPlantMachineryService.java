/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantMachinery;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantMachineryService extends AbstractProcessingPlantAttrService<ProcessingPlantMachinery> {

    public List<ProcessingPlantMachinery> findByActiveOrderByProcessingPlantMachineryNameAsc(Boolean active);
    public List<ProcessingPlantMachinery> search(SearchByNameDTO dto);
    
      public List<ProcessingPlantMachinery> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantMachineryNo);
}
