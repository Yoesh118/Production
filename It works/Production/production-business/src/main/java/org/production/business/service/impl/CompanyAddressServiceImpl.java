/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.CompanyAddress;
import org.production.business.repo.CompanyAddressRepo;
import org.production.business.service.CompanyAddressService;
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
public class CompanyAddressServiceImpl implements CompanyAddressService{

    @Resource
    private CompanyAddressRepo companyAddressRepo;
    @Resource
    private UserService userService;

    @Override
    public List<CompanyAddress> getAll() {
        return companyAddressRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public CompanyAddress get(String id) {
        return companyAddressRepo.findOne(id);
    }

    @Override
    public void delete(CompanyAddress t) {
        if (t.getCompanyAddressId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        companyAddressRepo.save(t);
    }

    @Override
    public List<CompanyAddress> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompanyAddress save(CompanyAddress t) {
        if (t.getCompanyAddressId().isEmpty()) {
            t.setCompanyAddressId(UUIDGen.generateUUID());
            t.setModifiedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return companyAddressRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return companyAddressRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(CompanyAddress current, CompanyAddress old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
