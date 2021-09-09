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
import org.production.business.domain.production.ProcessingPlantProductionRun;
import org.production.business.repo.production.ProcessingPlantProductionRunRepo;
import org.production.business.service.production.ProcessingPlantProductionRunService;
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
@Repository("processingPlantProductionRunService")
public class ProcessingPlantProductionRunServiceImpl implements ProcessingPlantProductionRunService {

    @Resource
    private ProcessingPlantProductionRunRepo processingPlantProductionRunRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessingPlantProductionRun> getAll() {
        return processingPlantProductionRunRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcessingPlantProductionRun get(String id) {
        return processingPlantProductionRunRepo.findOne(id);
    }

    @Override
    public void delete(ProcessingPlantProductionRun t) {
        if (t.getProcessingPlantProductionRunId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        processingPlantProductionRunRepo.save(t);

    }

    @Override
    public List<ProcessingPlantProductionRun> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessingPlantProductionRun save(ProcessingPlantProductionRun t) {
        if (t.getProcessingPlantProductionRunId().isEmpty()) {
            t.setProcessingPlantProductionRunId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processingPlantProductionRunRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processingPlantProductionRunRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessingPlantProductionRun current, ProcessingPlantProductionRun old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessingPlantProductionRun> findByActiveOrderByProcessingPlantProductionRunNo(Boolean active) {
        return processingPlantProductionRunRepo.findByActiveOrderByProcessingPlantProductionRunNoAsc(active);
    }

    @Override
    public List<ProcessingPlantProductionRun> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return processingPlantProductionRunRepo.findByActiveOrderByProcessingPlantProductionRunNoAsc(Boolean.TRUE);
        }
        return processingPlantProductionRunRepo.findByActiveOrderByProcessingPlantProductionRunNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProcessingPlantProductionRun> getByProcessingPlant(ProcessingPlant processingPlant) {
       return processingPlantProductionRunRepo.findByProcessingPlantAndActive(processingPlant, Boolean.TRUE);
    }

    @Override
    public List<ProcessingPlantProductionRun> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantProductionRunNo) {
       return processingPlantProductionRunRepo.findByProcessingPlantProductionRunNo(processingPlant, processingPlantProductionRunNo);
    }

}
