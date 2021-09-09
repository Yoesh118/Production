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
import org.production.business.domain.production.ProductWarehouseTools;
import org.production.business.repo.production.ProductWarehouseToolsRepo;
import org.production.business.service.production.ProductWarehouseToolsService;
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
@Repository("productWarehouseToolsService")
public class ProductWarehouseToolsServiceImpl implements ProductWarehouseToolsService {

    @Resource
    private ProductWarehouseToolsRepo productWarehouseToolsRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductWarehouseTools> getAll() {
        return productWarehouseToolsRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductWarehouseTools get(String id) {
        return productWarehouseToolsRepo.findOne(id);
    }

    @Override
    public void delete(ProductWarehouseTools t) {
        if (t.getProductWarehouseToolId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productWarehouseToolsRepo.save(t);

    }

    @Override
    public List<ProductWarehouseTools> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductWarehouseTools save(ProductWarehouseTools t) {
        if (t.getProductWarehouseToolId().isEmpty()) {
            t.setProductWarehouseToolId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productWarehouseToolsRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productWarehouseToolsRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductWarehouseTools current, ProductWarehouseTools old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductWarehouseTools> findByActiveOrderByProductWarehouseToolNo(Boolean active) {
        return productWarehouseToolsRepo.findByActiveOrderByProductWarehouseToolNoAsc(active);
    }

    @Override
    public List<ProductWarehouseTools> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productWarehouseToolsRepo.findByActiveOrderByProductWarehouseToolNoAsc(Boolean.TRUE);
        }
        return productWarehouseToolsRepo.findByActiveOrderByProductWarehouseToolNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProductWarehouseTools> getByProductWarehouse(ProductWarehouse productWarehouse) {
        return productWarehouseToolsRepo.findByActiveOrderByProductWarehouseToolNoAsc(Boolean.TRUE);
    }

    @Override
    public List<ProductWarehouseTools> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseToolsNo) {
       return productWarehouseToolsRepo.findByProductWarehouseToolNo(productWarehouse, productWarehouseToolsNo);
    }
}
