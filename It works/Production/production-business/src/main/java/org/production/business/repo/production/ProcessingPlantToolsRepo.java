/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ProcessingPlantTools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantTools;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantToolsRepo extends AbstractProcessingPlantAttrRepo<ProcessingPlantTools, String> {

    @Override
    public List<ProcessingPlantTools> findAll();

    public List<ProcessingPlantTools> findByActiveOrderByProcessingPlantToolNoAsc(Boolean active);

    @Query("from ProcessingPlantTools pc left join fetch pc.processingPlant where pc.processingPlant=:processingPlant and pc.processingPlantToolNo=:processingPlantToolNo")
    public List<ProcessingPlantTools> findByProcessingPlantToolNo(@Param("processingPlant") ProcessingPlant processingPlant, @Param("processingPlantToolNo") String processingPlantToolNo);

}
