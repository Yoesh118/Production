/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.repo.production.ProcessingPlantRepo;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchByNameDTO;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("processingPlantService")
public class ProcessingPlantServiceImpl implements ProcessingPlantService {

    @Resource
    private ProcessingPlantRepo processingPlantRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessingPlant> getAll() {
        return processingPlantRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcessingPlant get(String id) {
        return processingPlantRepo.findOne(id);
    }

    @Override
    public void delete(ProcessingPlant t) {
        if (t.getProcessingPlantId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        processingPlantRepo.save(t);

    }

    @Override
    public List<ProcessingPlant> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessingPlant save(ProcessingPlant t) {
        if (t.getProcessingPlantId().isEmpty()) {
            t.setProcessingPlantId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processingPlantRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processingPlantRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessingPlant current, ProcessingPlant old) {
        
        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (processingPlantRepo.findByName(current.getProcessingPlantName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (processingPlantRepo.findByName(current.getProcessingPlantName()) != null) {
                return true;
            }

        }

        return false;

    }


}
