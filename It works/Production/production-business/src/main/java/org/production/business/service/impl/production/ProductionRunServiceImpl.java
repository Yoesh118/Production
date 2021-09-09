/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductionRun;
import org.production.business.repo.production.ProductionRunRepo;
import org.production.business.service.production.ProductionRunService;
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
@Repository("productionRunService")
public class ProductionRunServiceImpl implements ProductionRunService {

    @Resource
    private ProductionRunRepo productionRunRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductionRun> getAll() {
        return productionRunRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductionRun get(String id) {
        return productionRunRepo.findOne(id);
    }

    @Override
    public void delete(ProductionRun t) {
        if (t.getProductionRunId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productionRunRepo.save(t);

    }

    @Override
    public List<ProductionRun> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductionRun save(ProductionRun t) {
        if (t.getProductionRunId().isEmpty()) {
            t.setProductionRunId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productionRunRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productionRunRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductionRun current, ProductionRun old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductionRun> findByActiveOrderByProductionRunDescription(Boolean active) {
        return productionRunRepo.findByActiveOrderByProductionRunDescriptionAsc(active);
    }

    @Override
    public List<ProductionRun> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productionRunRepo.findByProductionRunDescription(exp[0], Boolean.TRUE);
        }
        return productionRunRepo.findByProductionRunDescription(exp[0], Boolean.TRUE);

    }

}
