/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.FinishedProducts;
import org.production.business.repo.production.FinishedProductsRepo;
import org.production.business.service.production.FinishedProductsService;
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
@Repository("finishedProductsService")
public class FinishedProductsServiceImpl implements FinishedProductsService {

    @Resource
    private FinishedProductsRepo finishedProductsRepo;
    @Resource
    private UserService userService;

    @Override
    public List<FinishedProducts> getAll() {
        return finishedProductsRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public FinishedProducts get(String id) {
        return finishedProductsRepo.findOne(id);
    }

    @Override
    public void delete(FinishedProducts t) {
        if (t.getFinishedProductsId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        finishedProductsRepo.save(t);

    }

    @Override
    public List<FinishedProducts> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FinishedProducts save(FinishedProducts t) {
        if (t.getFinishedProductsId().isEmpty()) {
            t.setFinishedProductsId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return finishedProductsRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return finishedProductsRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(FinishedProducts current, FinishedProducts old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FinishedProducts> findByActiveOrderByFinishedProductsId(Boolean active) {
        return finishedProductsRepo.findByActiveOrderByFinishedProductsIdAsc(active);
    }

    @Override
    public List<FinishedProducts> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return finishedProductsRepo.findByFinishedProductsId(exp[0], Boolean.TRUE);
        }
        return finishedProductsRepo.findByFinishedProductsId(exp[0], Boolean.TRUE);

    }

}
