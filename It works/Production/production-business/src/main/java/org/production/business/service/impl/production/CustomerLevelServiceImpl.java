/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.CustomerLevel;
import org.production.business.repo.production.CustomerLevelRepo;
import org.production.business.service.production.CustomerLevelService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("customerLevelService")
public class CustomerLevelServiceImpl implements CustomerLevelService {

    @Resource
    private CustomerLevelRepo customerLevelRepo;
    @Resource
    private UserService userService;

    @Override
    public List<CustomerLevel> getAll() {
        return customerLevelRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public CustomerLevel get(String id) {

        return customerLevelRepo.findOne(id);
    }

    @Override
    public void delete(CustomerLevel t) {
        if (t.getCustomerLevelId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        customerLevelRepo.save(t);
    }

    @Override
    public List<CustomerLevel> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerLevel save(CustomerLevel t) {
        if (t.getCustomerLevelId().isEmpty()) {
            t.setCustomerLevelId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return customerLevelRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return customerLevelRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(CustomerLevel current, CustomerLevel old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (customerLevelRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (customerLevelRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
