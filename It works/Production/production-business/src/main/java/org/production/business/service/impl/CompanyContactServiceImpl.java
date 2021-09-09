/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.Company;
import org.production.business.domain.CompanyContact;
import org.production.business.domain.ContactType;
import org.production.business.repo.CompanyContactRepo;
import org.production.business.service.CompanyContactService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Repository
public class CompanyContactServiceImpl implements CompanyContactService {

    @Resource
    private CompanyContactRepo companyContactRepo;
    @Resource
    private UserService userService;

    @Override
    public List<CompanyContact> getAll() {
        return companyContactRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public CompanyContact get(String id) {
        return companyContactRepo.findOne(id);
    }

    @Override
    public void delete(CompanyContact t) {
        if (t.getCompanyContactId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        companyContactRepo.delete(t);
    }

    @Override
    public List<CompanyContact> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompanyContact save(CompanyContact t) {
        if (t.getCompanyContactId().isEmpty()) {
            t.setCompanyContactId(UUIDGen.generateUUID());
            t.setModifiedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return companyContactRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return companyContactRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(CompanyContact current, CompanyContact old) {
        if (!current.getCompanyContactId().isEmpty()) {
            /**
             * @param current is in existence
             */
            if (!((current.getContactDetail().equals(old.getContactDetail())) && (current.getContactType().equals(old.getContactType())))) {
                if (getByContactTypeAndContactDetail(current.getCompany(), current.getContactType(), current.getContactDetail()) != null) {
                    return true;
                }
            }
        } else if (current.getCompanyContactId().isEmpty()) {
            if (getByContactTypeAndContactDetail(current.getCompany(), current.getContactType(), current.getContactDetail()) != null) {
                return true;
            }
        }
        return false;

    }

    @Override
    public List<CompanyContact> getByCompany(Company company) {
        return companyContactRepo.findByCompanyAndActive(company, Boolean.TRUE);
    }

    @Override
    public CompanyContact getByContactTypeAndContactDetail(Company company, ContactType contactType, String contactDetail) {
        return companyContactRepo.findByCompanyAndTypeAndItem(company, contactType, contactDetail);
    }

}
