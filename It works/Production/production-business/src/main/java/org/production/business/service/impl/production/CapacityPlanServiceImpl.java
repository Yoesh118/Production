/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.CapacityPlan;
import org.production.business.repo.production.CapacityPlanRepo;
import org.production.business.service.production.CapacityPlanService;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchByNameDTO;
import org.production.business.utils.UUIDGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("capacityPlanService")
public class CapacityPlanServiceImpl implements CapacityPlanService {

    @Resource
    private CapacityPlanRepo capacityPlanRepo;
    @Resource
    private UserService userService;
    
    @Override
    public List<CapacityPlan> getAll() {
        return capacityPlanRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public CapacityPlan get(String id) {
        return capacityPlanRepo.findOne(id);
    }

    @Override
    public void delete(CapacityPlan t) {
        if (t.getCapacityPlanId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        capacityPlanRepo.save(t);

    }

    @Override
    public List<CapacityPlan> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CapacityPlan save(CapacityPlan t) {
        if (t.getCapacityPlanId().isEmpty()) {
            t.setCapacityPlanId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return capacityPlanRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return capacityPlanRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(CapacityPlan current, CapacityPlan old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CapacityPlan> findByActiveOrderByCapacityPlanId(Boolean active) {
        return capacityPlanRepo.findByActiveOrderByCapacityPlanIdAsc(active);
    }

    @Override
    public List<CapacityPlan> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return capacityPlanRepo.findByCapacityPlanId(exp[0], Boolean.TRUE);
        }
        return capacityPlanRepo.findByCapacityPlanId(exp[0], Boolean.TRUE);

    }

}
