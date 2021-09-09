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
import org.production.business.domain.production.ProcessingPlantProductionTeam;
import org.production.business.repo.production.ProcessingPlantProductionTeamRepo;
import org.production.business.service.production.ProcessingPlantProductionTeamService;
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
@Repository("processingPlantProductionTeamService")
public class ProcessingPlantProductionTeamServiceImpl implements ProcessingPlantProductionTeamService {

    @Resource
    private ProcessingPlantProductionTeamRepo processingPlantProductionTeamRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessingPlantProductionTeam> getAll() {
        return processingPlantProductionTeamRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcessingPlantProductionTeam get(String id) {
        return processingPlantProductionTeamRepo.findOne(id);
    }

    @Override
    public void delete(ProcessingPlantProductionTeam t) {
        if (t.getProcessingPlantProductionTeamId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        processingPlantProductionTeamRepo.save(t);

    }

    @Override
    public List<ProcessingPlantProductionTeam> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessingPlantProductionTeam save(ProcessingPlantProductionTeam t) {
        if (t.getProcessingPlantProductionTeamId().isEmpty()) {
            t.setProcessingPlantProductionTeamId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processingPlantProductionTeamRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processingPlantProductionTeamRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessingPlantProductionTeam current, ProcessingPlantProductionTeam old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessingPlantProductionTeam> findByActiveOrderByProcessingPlantProductionTeamNo(Boolean active) {
        return processingPlantProductionTeamRepo.findByActiveOrderByProcessingPlantProductionTeamNoAsc(active);
    }

    @Override
    public List<ProcessingPlantProductionTeam> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return processingPlantProductionTeamRepo.findByActiveOrderByProcessingPlantProductionTeamNoAsc(Boolean.TRUE);
        }
        return processingPlantProductionTeamRepo.findByActiveOrderByProcessingPlantProductionTeamNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProcessingPlantProductionTeam> getByProcessingPlant(ProcessingPlant processingPlant) {
        return processingPlantProductionTeamRepo.findByProcessingPlantAndActive(processingPlant, Boolean.TRUE);
    }

    @Override
    public List<ProcessingPlantProductionTeam> getByProcessingPlant(ProcessingPlant processingPlant, String processingPlantProductionTeamNo) {
       return processingPlantProductionTeamRepo.findByProcessingPlantProductionTeamNo(processingPlant, processingPlantProductionTeamNo);
    }

}
