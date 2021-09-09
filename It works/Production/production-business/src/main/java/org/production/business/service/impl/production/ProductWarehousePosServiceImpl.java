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
import org.production.business.domain.production.ProductWarehousePos;
import org.production.business.repo.production.ProductWarehousePosRepo;
import org.production.business.service.production.ProductWarehousePosService;
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
@Repository("productWarehousePosService")
public class ProductWarehousePosServiceImpl implements ProductWarehousePosService {

    @Resource
    private ProductWarehousePosRepo productWarehousePosRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductWarehousePos> getAll() {
        return productWarehousePosRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductWarehousePos get(String id) {
        return productWarehousePosRepo.findOne(id);
    }

    @Override
    public void delete(ProductWarehousePos t) {
        if (t.getProductWarehousePosId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productWarehousePosRepo.save(t);

    }

    @Override
    public List<ProductWarehousePos> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductWarehousePos save(ProductWarehousePos t) {
        if (t.getProductWarehousePosId().isEmpty()) {
            t.setProductWarehousePosId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productWarehousePosRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productWarehousePosRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductWarehousePos current, ProductWarehousePos old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductWarehousePos> findByActiveOrderByProductWarehousePosNo(Boolean active) {
        return productWarehousePosRepo.findByActiveOrderByProductWarehousePosNoAsc(active);
    }

    @Override
    public List<ProductWarehousePos> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productWarehousePosRepo.findByActiveOrderByProductWarehousePosNoAsc(Boolean.TRUE);
        }
        return productWarehousePosRepo.findByActiveOrderByProductWarehousePosNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProductWarehousePos> getByProductWarehouse(ProductWarehouse productWarehouse) {
        return productWarehousePosRepo.findByActiveOrderByProductWarehousePosNoAsc(Boolean.TRUE);
    }

    @Override
    public List<ProductWarehousePos> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehousePosNo) {
       return productWarehousePosRepo.findByProductWarehousePosNo(productWarehouse, productWarehousePosNo);
    }
}
