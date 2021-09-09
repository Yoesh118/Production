/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantMaterial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcessingPlantMaterialRepo extends AbstractProcessingPlantAttrRepo<ProcessingPlantMaterial, String> {

    @Override
    public List<ProcessingPlantMaterial> findAll();

    public List<ProcessingPlantMaterial> findByActiveOrderByProcessingPlantMaterialNameAsc(Boolean active);
    
    @Query("from ProcessingPlantMaterial pm left join fetch pm.processingPlant where pm.processingPlant=:processingPlant and pm.processingPlantMaterialName=:processingPlantMaterialName")
    public List<ProcessingPlantMaterial> findByProcessingPlantMaterialName(@Param("processingPlant") ProcessingPlant processingPlant, @Param("processingPlantMaterialName") String processingPlantMaterialName);


}
