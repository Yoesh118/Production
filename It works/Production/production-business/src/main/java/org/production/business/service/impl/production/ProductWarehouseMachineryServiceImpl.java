/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseMachinery;
import org.production.business.repo.production.ProductWarehouseMachineryRepo;
import org.production.business.service.production.ProductWarehouseMachineryService;
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
@Repository("productWarehouseMachineryService")
public class ProductWarehouseMachineryServiceImpl implements ProductWarehouseMachineryService {

    @Resource
    private ProductWarehouseMachineryRepo productWarehouseMachineryRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductWarehouseMachinery> getAll() {
        return productWarehouseMachineryRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductWarehouseMachinery get(String id) {
        return productWarehouseMachineryRepo.findOne(id);
    }

    @Override
    public void delete(ProductWarehouseMachinery t) {
        if (t.getProductWarehouseMachineryId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productWarehouseMachineryRepo.save(t);

    }

    @Override
    public List<ProductWarehouseMachinery> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductWarehouseMachinery save(ProductWarehouseMachinery t) {
        if (t.getProductWarehouseMachineryId().isEmpty()) {
            t.setProductWarehouseMachineryId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productWarehouseMachineryRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productWarehouseMachineryRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductWarehouseMachinery current, ProductWarehouseMachinery old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductWarehouseMachinery> findByActiveOrderByProductWarehouseMachineryNameAsc(Boolean active) {
        return productWarehouseMachineryRepo.findByActiveOrderByProductWarehouseMachineryNameAsc(active);
    }

    @Override
    public List<ProductWarehouseMachinery> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productWarehouseMachineryRepo.findByActiveOrderByProductWarehouseMachineryNameAsc(Boolean.TRUE);
        }
        return productWarehouseMachineryRepo.findByActiveOrderByProductWarehouseMachineryNameAsc(Boolean.TRUE);

    }

    
    @Override
    public List<ProductWarehouseMachinery> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseMachineryNo ) {
        return productWarehouseMachineryRepo.findByProductWarehouseMachineryName(productWarehouse, productWarehouseMachineryNo);
    }

    @Override
    public List<ProductWarehouseMachinery> getByProductWarehouse(ProductWarehouse productWarehouse) {
       return productWarehouseMachineryRepo.findByActiveOrderByProductWarehouseMachineryNameAsc(Boolean.TRUE);
    }
    
}


