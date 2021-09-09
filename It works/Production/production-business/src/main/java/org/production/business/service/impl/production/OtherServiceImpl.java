/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.Other;
import org.production.business.repo.production.OtherRepo;
import org.production.business.service.production.OtherService;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchByNameDTO;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("otherService")
public class OtherServiceImpl implements OtherService {

    @Resource
    private OtherRepo otherRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Other> getAll() {
        return otherRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public Other get(String id) {
        return otherRepo.findOne(id);
    }

    @Override
    public void delete(Other t) {
        if (t.getOtherId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        otherRepo.save(t);

    }

    @Override
    public List<Other> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Other save(Other t) {
        if (t.getOtherId().isEmpty()) {
            t.setOtherId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return otherRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return otherRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Other current, Other old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Other> findByActiveOrderByName(Boolean active) {
        return otherRepo.findByActiveOrderByNameAsc(active);
    }

    @Override
    public List<Other> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return otherRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
        }
        return otherRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public List<Other> getByProductionCost(ProductionCost productionCost) {
        return otherRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

    @Override
    public List<Other> getByProductionCost(ProductionCost productionCost, String otherNo) {
       return otherRepo.findByName(productionCost, otherNo);
    }
}
