/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.WorkIncident;
import org.production.business.repo.production.WorkIncidentRepo;
import org.production.business.service.production.WorkIncidentService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("workIncidentService")
public class WorkIncidentServiceImpl implements WorkIncidentService {

    @Resource
    private WorkIncidentRepo workIncidentRepo;
    @Resource
    private UserService userService;

    @Override
    public List<WorkIncident> getAll() {
        return workIncidentRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public WorkIncident get(String id) {

        return workIncidentRepo.findOne(id);
    }

    @Override
    public void delete(WorkIncident t) {
        if (t.getWorkIncidentId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        workIncidentRepo.save(t);
    }

    @Override
    public List<WorkIncident> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WorkIncident save(WorkIncident t) {
        if (t.getWorkIncidentId().isEmpty()) {
            t.setWorkIncidentId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return workIncidentRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return workIncidentRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(WorkIncident current, WorkIncident old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (workIncidentRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (workIncidentRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
