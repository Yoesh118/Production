/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProcessPlan;
import org.production.business.repo.production.ProcessPlanRepo;
import org.production.business.service.production.ProcessPlanService;
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
@Repository("processPlanService")
public class ProcessPlanServiceImpl implements ProcessPlanService {

    @Resource
    private ProcessPlanRepo processPlanRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcessPlan> getAll() {
        return processPlanRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcessPlan get(String id) {
        return processPlanRepo.findOne(id);
    }

    @Override
    public void delete(ProcessPlan t) {
        if (t.getProcessPlanId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        processPlanRepo.save(t);

    }

    @Override
    public List<ProcessPlan> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessPlan save(ProcessPlan t) {
        if (t.getProcessPlanId().isEmpty()) {
            t.setProcessPlanId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return processPlanRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return processPlanRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcessPlan current, ProcessPlan old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessPlan> findByActiveOrderByProcessPlanId(Boolean active) {
        return processPlanRepo.findByActiveOrderByProcessPlanIdAsc(active);
    }

    @Override
    public List<ProcessPlan> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return processPlanRepo.findByProcessPlanId(exp[0], Boolean.TRUE);
        }
        return processPlanRepo.findByProcessPlanId(exp[0], Boolean.TRUE);

    }

}
