/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Suppliers;
import org.production.business.repo.production.SuppliersRepo;
import org.production.business.service.production.SuppliersService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("suppliersService")
public class SuppliersServiceImpl implements SuppliersService {

    @Resource
    private SuppliersRepo suppliersRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Suppliers> getAll() {
        return suppliersRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Suppliers get(String id) {

        return suppliersRepo.findOne(id);
    }

    @Override
    public void delete(Suppliers t) {
        if (t.getSuppliersId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        suppliersRepo.save(t);
    }

    @Override
    public List<Suppliers> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Suppliers save(Suppliers t) {
        if (t.getSuppliersId().isEmpty()) {
            t.setSuppliersId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return suppliersRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return suppliersRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Suppliers current, Suppliers old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (suppliersRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (suppliersRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
