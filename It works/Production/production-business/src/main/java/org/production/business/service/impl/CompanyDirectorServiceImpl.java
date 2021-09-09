/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.CompanyDirector;
import org.production.business.repo.CompanyDirectorRepo;
import org.production.business.service.CompanyDirectorService;
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
public class CompanyDirectorServiceImpl implements CompanyDirectorService {

    @Resource
    private CompanyDirectorRepo companyDirectorRepo;
    @Resource
    private UserService userService;

    @Override
    public List<CompanyDirector> getAll() {
        return companyDirectorRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public CompanyDirector get(String id) {

        return companyDirectorRepo.findOne(id);
    }

    @Override
    public void delete(CompanyDirector t) {
        if (t.getCompanyDirectorId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        companyDirectorRepo.save(t);
    }

    @Override
    public List<CompanyDirector> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompanyDirector save(CompanyDirector t) {
        if (t.getCompanyDirectorId().isEmpty()) {
            t.setCompanyDirectorId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return companyDirectorRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return companyDirectorRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(CompanyDirector current, CompanyDirector old) {
          if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (companyDirectorRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (companyDirectorRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;
    }
    

    @Override
    public List<CompanyDirector> getActive() {
        return companyDirectorRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

}
