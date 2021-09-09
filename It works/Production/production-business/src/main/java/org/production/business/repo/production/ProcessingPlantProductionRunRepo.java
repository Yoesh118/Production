/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantProductionRun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantProductionRunRepo extends AbstractProcessingPlantAttrRepo<ProcessingPlantProductionRun, String> {

    @Override
    public List<ProcessingPlantProductionRun> findAll();

    public List<ProcessingPlantProductionRun> findByActiveOrderByProcessingPlantProductionRunNoAsc(Boolean active);
    
     @Query("from ProcessingPlantProductionRun pr left join fetch pr.processingPlant where pr.processingPlant=:processingPlant and pr.processingPlantProductionRunNo=:processingPlantProductionRunNo")
    public List<ProcessingPlantProductionRun> findByProcessingPlantProductionRunNo(@Param("processingPlant") ProcessingPlant processingPlant, @Param("processingPlantProductionRunNo") String processingPlantProductionRunNo);
}
