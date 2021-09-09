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
import org.production.business.repo.production.ProductionCostRepo;
import org.production.business.service.production.ProductionCostService;
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
@Repository("productionCostService")
public class ProductionCostServiceImpl implements ProductionCostService {

    @Resource
    private ProductionCostRepo productionCostRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductionCost> getAll() {
        return productionCostRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductionCost get(String id) {
        return productionCostRepo.findOne(id);
    }

    @Override
    public void delete(ProductionCost t) {
        if (t.getProductionCostId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productionCostRepo.save(t);

    }

    @Override
    public List<ProductionCost> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductionCost save(ProductionCost t) {
        if (t.getProductionCostId().isEmpty()) {
            t.setProductionCostId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productionCostRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productionCostRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductionCost current, ProductionCost old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductionCost> findByActiveOrderByName(Boolean active) {
        return productionCostRepo.findByActiveOrderByNameAsc(active);
    }

    @Override
    public List<ProductionCost> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productionCostRepo.findByName(exp[0], Boolean.TRUE);
        }
        return productionCostRepo.findByName(exp[0], Boolean.TRUE);

    }

}
