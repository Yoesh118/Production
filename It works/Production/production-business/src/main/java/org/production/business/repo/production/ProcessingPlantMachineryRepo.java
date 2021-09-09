/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantMachinery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantMachineryRepo extends AbstractProcessingPlantAttrRepo<ProcessingPlantMachinery, String> {

    @Override
    public List<ProcessingPlantMachinery> findAll();

    public List<ProcessingPlantMachinery> findByActiveOrderByProcessingPlantMachineryNameAsc(Boolean active);

  
     @Query("from ProcessingPlantMachinery pp left join fetch pp.processingPlant where pp.processingPlant=:processingPlant and pp.processingPlantMachineryNo=:processingPlantMachineryNo")
    public List<ProcessingPlantMachinery> findByProcessingPlantMachineryName(@Param("processingPlant") ProcessingPlant processingPlant, @Param("processingPlantMachineryNo") String processingPlantMachineryNo);



}
