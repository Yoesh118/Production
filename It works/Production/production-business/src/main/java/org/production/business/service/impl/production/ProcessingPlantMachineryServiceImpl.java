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
import org.production.business.domain.production.ProcessingPlantMachinery;
import org.production.business.repo.production.ProcessingPlantMachineryRepo;
import org.production.business.service.production.ProcessingPlantMachineryService;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchByNameDTO;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("processingPlantMachineryService")
public class ProcessingPlantMachineryServiceImpl implements ProcessingPlantMachineryService {

    @Resource
    private ProcessingPlantMachineryRepo processingPlantMachineryRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessingPlantMachinery> getAll() {
        return processingPlantMachineryRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcessingPlantMachinery get(String id) {
        return processingPlantMachineryRepo.findOne(id);
    }

    @Override
    public void delete(ProcessingPlantMachinery t) {
        if (t.getProcessingPlantMachineryId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        processingPlantMachineryRepo.save(t);

    }

    @Override
    public List<ProcessingPlantMachinery> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessingPlantMachinery save(ProcessingPlantMachinery t) {
        if (t.getProcessingPlantMachineryId().isEmpty()) {
            t.setProcessingPlantMachineryId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processingPlantMachineryRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processingPlantMachineryRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessingPlantMachinery current, ProcessingPlantMachinery old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessingPlantMachinery> findByActiveOrderByProcessingPlantMachineryNameAsc(Boolean active) {
        return processingPlantMachineryRepo.findByActiveOrderByProcessingPlantMachineryNameAsc(active);
    }

    @Override
    public List<ProcessingPlantMachinery> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return processingPlantMachineryRepo.findByActiveOrderByProcessingPlantMachineryNameAsc(Boolean.TRUE);
        }
        return processingPlantMachineryRepo.findByActiveOrderByProcessingPlantMachineryNameAsc(Boolean.TRUE);

    }

    
    @Override
    public List<ProcessingPlantMachinery> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantMachineryNo ) {
        return processingPlantMachineryRepo.findByProcessingPlantMachineryName(processingPlant, processingPlantMachineryNo);
    }

    @Override
    public List<ProcessingPlantMachinery> getByProcessingPlant(ProcessingPlant processingPlant) {
       return processingPlantMachineryRepo.findByProcessingPlantAndActive(processingPlant, Boolean.TRUE);
    }
    
}


