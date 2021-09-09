/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Customers;
import org.production.business.repo.production.CustomersRepo;
import org.production.business.service.production.CustomersService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("customersService")
public class CustomersServiceImpl implements CustomersService {

    @Resource
    private CustomersRepo customersRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Customers> getAll() {
        return customersRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Customers get(String id) {

        return customersRepo.findOne(id);
    }

    @Override
    public void delete(Customers t) {
        if (t.getCustomersId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        customersRepo.save(t);
    }

    @Override
    public List<Customers> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customers save(Customers t) {
        if (t.getCustomersId().isEmpty()) {
            t.setCustomersId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return customersRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return customersRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Customers current, Customers old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (customersRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (customersRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
