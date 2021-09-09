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
import org.production.business.domain.production.ProductWarehouseProduct;
import org.production.business.repo.production.ProductWarehouseProductRepo;
import org.production.business.service.production.ProductWarehouseProductService;
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
@Repository("productWarehouseProductService")
public class ProductWarehouseProductServiceImpl implements ProductWarehouseProductService {

    @Resource
    private ProductWarehouseProductRepo productWarehouseProductRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductWarehouseProduct> getAll() {
        return productWarehouseProductRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductWarehouseProduct get(String id) {
        return productWarehouseProductRepo.findOne(id);
    }

    @Override
    public void delete(ProductWarehouseProduct t) {
        if (t.getProductWarehouseProductId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productWarehouseProductRepo.save(t);

    }

    @Override
    public List<ProductWarehouseProduct> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductWarehouseProduct save(ProductWarehouseProduct t) {
        if (t.getProductWarehouseProductId().isEmpty()) {
            t.setProductWarehouseProductId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productWarehouseProductRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productWarehouseProductRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductWarehouseProduct current, ProductWarehouseProduct old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductWarehouseProduct> findByActiveOrderByProductWarehouseProductNo(Boolean active) {
        return productWarehouseProductRepo.findByActiveOrderByProductWarehouseProductNoAsc(active);
    }

    @Override
    public List<ProductWarehouseProduct> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productWarehouseProductRepo.findByActiveOrderByProductWarehouseProductNoAsc(Boolean.TRUE);
        }
        return productWarehouseProductRepo.findByActiveOrderByProductWarehouseProductNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProductWarehouseProduct> getByProductWarehouse(ProductWarehouse productWarehouse) {
        return productWarehouseProductRepo.findByActiveOrderByProductWarehouseProductNoAsc(Boolean.TRUE);
    }

    @Override
    public List<ProductWarehouseProduct> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseProductNo) {
       return productWarehouseProductRepo.findByProductWarehouseProductNo(productWarehouse, productWarehouseProductNo);
    }
}
