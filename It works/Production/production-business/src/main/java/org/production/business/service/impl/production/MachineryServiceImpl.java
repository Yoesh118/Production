/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Machinery;
import org.production.business.repo.production.MachineryRepo;
import org.production.business.service.production.MachineryService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("machineryService")
public class MachineryServiceImpl implements MachineryService {

    @Resource
    private MachineryRepo machineryRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Machinery> getAll() {
        return machineryRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Machinery get(String id) {

        return machineryRepo.findOne(id);
    }

    @Override
    public void delete(Machinery t) {
        if (t.getMachineryId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        machineryRepo.save(t);
    }

    @Override
    public List<Machinery> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Machinery save(Machinery t) {
        if (t.getMachineryId().isEmpty()) {
            t.setMachineryId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return machineryRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return machineryRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Machinery current, Machinery old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (machineryRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (machineryRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
