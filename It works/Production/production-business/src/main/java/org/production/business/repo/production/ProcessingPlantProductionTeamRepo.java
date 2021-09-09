/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantProductionTeam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantProductionTeamRepo extends AbstractProcessingPlantAttrRepo<ProcessingPlantProductionTeam, String> {

    @Override
    public List<ProcessingPlantProductionTeam> findAll();

    public List<ProcessingPlantProductionTeam> findByActiveOrderByProcessingPlantProductionTeamNoAsc(Boolean active);

    @Query("from ProcessingPlantProductionTeam pt left join fetch pt.processingPlant where pt.processingPlant=:processingPlant and pt.processingPlantProductionTeamNo=:processingPlantProductionTeamNo")
    public List<ProcessingPlantProductionTeam> findByProcessingPlantProductionTeamNo(@Param("processingPlant") ProcessingPlant processingPlant, @Param("processingPlantProductionTeamNo") String processingPlantProductionTeamNo);

}
