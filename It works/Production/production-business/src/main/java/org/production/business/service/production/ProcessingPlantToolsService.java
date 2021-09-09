/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProcessingPlantTools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantTools;
import org.production.business.util.dto.SearchByNameDTO;

/*
 * @author  Rachel Makwara
 */
public interface ProcessingPlantToolsService extends AbstractProcessingPlantAttrService<ProcessingPlantTools> {

    public List<ProcessingPlantTools> findByActiveOrderByProcessingPlantToolNo(Boolean active);

    public List<ProcessingPlantTools> search(SearchByNameDTO dto);

    public List<ProcessingPlantTools> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantToolNo);

}
