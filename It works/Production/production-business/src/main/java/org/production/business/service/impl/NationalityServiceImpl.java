/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.Nationality;
import org.production.business.repo.NationalityRepo;
import org.production.business.service.NationalityService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository
public class NationalityServiceImpl implements NationalityService {

    @Resource
    private NationalityRepo nationalityRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Nationality> getAll() {
        return nationalityRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Nationality get(String id) {

        return nationalityRepo.findOne(id);
    }

    @Override
    public void delete(Nationality t) {
        if (t.getNationalityId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        nationalityRepo.save(t);
    }

    @Override
    public List<Nationality> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nationality save(Nationality t) {
        if (t.getNationalityId().isEmpty()) {
            t.setNationalityId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return nationalityRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return nationalityRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Nationality current, Nationality old) {
          if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (nationalityRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (nationalityRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;
    }
    

    @Override
    public List<Nationality> getActive() {
        return nationalityRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

}
