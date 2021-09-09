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
import org.production.business.repo.production.ProductWarehouseRepo;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("productWarehouseService")
public class ProductWarehouseServiceImpl implements ProductWarehouseService {

    @Resource
    private ProductWarehouseRepo productWarehouseRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductWarehouse> getAll() {
        return productWarehouseRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductWarehouse get(String id) {
        return productWarehouseRepo.findOne(id);
    }

    @Override
    public void delete(ProductWarehouse t) {
        if (t.getWarehouseId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productWarehouseRepo.save(t);

    }

    @Override
    public List<ProductWarehouse> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductWarehouse save(ProductWarehouse t) {
        if (t.getWarehouseId().isEmpty()) {
            t.setWarehouseId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productWarehouseRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productWarehouseRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductWarehouse current, ProductWarehouse old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

/*    @Override
    public List<ProductWarehouse> findByActiveOrderByWarehouseDescription(Boolean active) {
        return productWarehouseRepo.findByActiveOrderByWarehouseDescriptionAsc(active);
    }

    @Override
    public List<ProductWarehouse> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productWarehouseRepo.findByWarehouseDescription(exp[0], Boolean.TRUE);
        }
        return productWarehouseRepo.findByWarehouseDescription(exp[0], Boolean.TRUE);

    } */

}
