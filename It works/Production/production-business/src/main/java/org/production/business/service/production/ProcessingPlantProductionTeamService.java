/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantProductionTeam;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantProductionTeamService extends AbstractProcessingPlantAttrService<ProcessingPlantProductionTeam> {

    public List<ProcessingPlantProductionTeam> findByActiveOrderByProcessingPlantProductionTeamNo(Boolean active);
    public List<ProcessingPlantProductionTeam> search(SearchByNameDTO dto);
    
     public List<ProcessingPlantProductionTeam> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantProductionTeamNo);
}
