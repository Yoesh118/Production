/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantMaterial;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantMaterialService extends AbstractProcessingPlantAttrService<ProcessingPlantMaterial> {

    public List<ProcessingPlantMaterial> findByActiveOrderByProcessingPlantMaterialName(Boolean active);
    public List<ProcessingPlantMaterial> search(SearchByNameDTO dto);
    
     public List<ProcessingPlantMaterial> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantMaterialName);
}
