/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.City;
import org.production.business.service.CityService;
import org.production.business.repo.CityRepo;
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
public class CityServiceImpl implements CityService {

    @Resource
    private CityRepo cityRepo;
    @Resource
    private UserService userService;

    @Override
    public List<City> getAll() {
        return cityRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

    @Override
    public City get(String id) {
        return cityRepo.findOne(id);
    }

    @Override
    public void delete(City t) {
        if (t.getCityId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        cityRepo.save(t);
    }

    @Override
    public List<City> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public City save(City t) {
        if (t.getCityId() == null || t.getCityId().trim().isEmpty()) {
            t.setCityId(UUIDGen.generateUUID());
            t.setModifiedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return cityRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return cityRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(City current, City old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (cityRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (cityRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
