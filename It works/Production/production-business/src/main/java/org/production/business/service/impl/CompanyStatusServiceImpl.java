/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.CompanyStatus;
import org.production.business.repo.CompanyStatusRepo;
import org.production.business.service.CompanyStatusService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("companyStatusService")
public class CompanyStatusServiceImpl implements CompanyStatusService {

    @Resource
    private CompanyStatusRepo companyStatusRepo;
    @Resource
    private UserService userService;

    @Override
    public List<CompanyStatus> getAll() {
        return companyStatusRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

    @Override
    public CompanyStatus get(String id) {
        return companyStatusRepo.findOne(id);
    }

    @Override
    public void delete(CompanyStatus t) {
        if (t.getCompanyStatusId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        companyStatusRepo.save(t);
    }

    @Override
    public List<CompanyStatus> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompanyStatus save(CompanyStatus t) {
        if (t.getCompanyStatusId().isEmpty()) {
            t.setCompanyStatusId(UUIDGen.generateUUID());
            t.setModifiedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return companyStatusRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return companyStatusRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(CompanyStatus current, CompanyStatus old) {
        if (current.getCompanyStatusId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (getByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getCompanyStatusId() == null) {

            if (getByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

    @Override
    public CompanyStatus getByName(String name) {
        return companyStatusRepo.findByName(name);
    }
    

}
