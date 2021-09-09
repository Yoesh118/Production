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
import org.production.business.domain.production.ProcessingPlantTools;
import org.production.business.repo.production.ProcessingPlantToolsRepo;
import org.production.business.service.production.ProcessingPlantToolsService;
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
@Repository("processingPlantToolsService")
public class ProcessingPlantToolsServiceImpl implements ProcessingPlantToolsService {

    @Resource
    private ProcessingPlantToolsRepo processingPlantToolsRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessingPlantTools> getAll() {
        return processingPlantToolsRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcessingPlantTools get(String id) {
        return processingPlantToolsRepo.findOne(id);
    }

    @Override
    public void delete(ProcessingPlantTools t) {
        if (t.getProcessingPlantToolId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        processingPlantToolsRepo.save(t);

    }

    @Override
    public List<ProcessingPlantTools> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessingPlantTools save(ProcessingPlantTools t) {
        if (t.getProcessingPlantToolId().isEmpty()) {
            t.setProcessingPlantToolId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processingPlantToolsRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processingPlantToolsRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessingPlantTools current, ProcessingPlantTools old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessingPlantTools> findByActiveOrderByProcessingPlantToolNo(Boolean active) {
        return processingPlantToolsRepo.findByActiveOrderByProcessingPlantToolNoAsc(active);
    }

    @Override
    public List<ProcessingPlantTools> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return processingPlantToolsRepo.findByActiveOrderByProcessingPlantToolNoAsc(Boolean.TRUE);
        }
        return processingPlantToolsRepo.findByActiveOrderByProcessingPlantToolNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProcessingPlantTools> getByProcessingPlant(ProcessingPlant processingPlant) {
        return processingPlantToolsRepo.findByProcessingPlantAndActive(processingPlant, Boolean.TRUE);
    }

    @Override
    public List<ProcessingPlantTools> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantToolsNo) {
       return processingPlantToolsRepo.findByProcessingPlantToolNo(processingPlant, processingPlantToolsNo);
    }
}
