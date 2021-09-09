/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProcessingPlantMaterial;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.repo.production.ProcessingPlantMaterialRepo;
import org.production.business.service.production.ProcessingPlantMaterialService;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchByNameDTO;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Repository
public class ProcessingPlantMaterialServiceImpl implements ProcessingPlantMaterialService {

    @Resource
    private ProcessingPlantMaterialRepo processingPlantMaterialRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessingPlantMaterial> getAll() {
        return processingPlantMaterialRepo.findByActive(Boolean.TRUE);

    }

    @Override
    public ProcessingPlantMaterial get(String id) {

        return processingPlantMaterialRepo.findOne(id);
    }

    @Override
    public void delete(ProcessingPlantMaterial t) {
        if (t.getProcessingPlantMaterialId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        processingPlantMaterialRepo.delete(t);
    }

    @Override
    public List<ProcessingPlantMaterial> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessingPlantMaterial save(ProcessingPlantMaterial t) {
        if (t.getProcessingPlantMaterialId().isEmpty()) {
            t.setProcessingPlantMaterialId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processingPlantMaterialRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processingPlantMaterialRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessingPlantMaterial current, ProcessingPlantMaterial old) {
        if (!current.getProcessingPlantMaterialId().isEmpty()) {
            /**
             * @param current is in existence
             */
            if (!((current.getProcessingPlantMaterialName().equals(old.getProcessingPlantMaterialName())) && (current.getDateAcquired().equals(old.getDateAcquired())))) {
                if (getByProcessingPlant(current.getProcessingPlant(), current.getProcessingPlantMaterialName()) != null) {
                    return true;
                }
            }
        } else if (current.getProcessingPlantMaterialId().isEmpty()) {
            if (getByProcessingPlant(current.getProcessingPlant(), current.getProcessingPlantMaterialName()) != null) {
                return true;
            }
        }
        return false;
    }

    
    @Override
    public List<ProcessingPlantMaterial> findByActiveOrderByProcessingPlantMaterialName(Boolean active) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessingPlantMaterial> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return processingPlantMaterialRepo.findByActiveOrderByProcessingPlantMaterialNameAsc(Boolean.TRUE);
        }
        return processingPlantMaterialRepo.findByActiveOrderByProcessingPlantMaterialNameAsc(Boolean.TRUE);

    }

    @Override
    public List<ProcessingPlantMaterial> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantMaterialName) {
        return processingPlantMaterialRepo.findByProcessingPlantMaterialName(processingPlant, processingPlantMaterialName);
    }

    @Override
    public List<ProcessingPlantMaterial> getByProcessingPlant(ProcessingPlant processingPlant) {
        return processingPlantMaterialRepo.findByProcessingPlantAndActive(processingPlant, Boolean.TRUE);
    }

}
