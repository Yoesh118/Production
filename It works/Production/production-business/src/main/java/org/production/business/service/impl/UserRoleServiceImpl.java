/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.UserRole;
import org.production.business.repo.UserRoleRepo;
import org.production.business.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService{

    @Resource
    private UserRoleRepo userRoleRepo;
    @Resource
    private UserService userService;

    @Override
    public List<UserRole> getAll() {
        return userRoleRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

    @Override
    public UserRole get(String id) {
        return userRoleRepo.findOne(id);
    }

    @Override
    public void delete(UserRole t) {
        if (t.getRoleId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        userRoleRepo.save(t);
    }

    @Override
    public List<UserRole> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserRole save(UserRole t) {
         if (t.getRoleId().isEmpty()) {
            t.setRoleId(UUIDGen.generateUUID());
            t.setModifiedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return userRoleRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return userRoleRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(UserRole current, UserRole old) {
        
        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (userRoleRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (userRoleRepo.findByName(current.getName()) != null) {
                return true;
            }
        
        }
        
        return false;
  
    }

}
