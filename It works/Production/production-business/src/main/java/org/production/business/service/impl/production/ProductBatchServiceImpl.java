/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductBatch;
import org.production.business.repo.production.ProductBatchRepo;
import org.production.business.service.production.ProductBatchService;
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
@Repository("productBatchService")
public class ProductBatchServiceImpl implements ProductBatchService {

    @Resource
    private ProductBatchRepo productBatchRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductBatch> getAll() {
        return productBatchRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductBatch get(String id) {
        return productBatchRepo.findOne(id);
    }

    @Override
    public void delete(ProductBatch t) {
        if (t.getProductBatchId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productBatchRepo.save(t);

    }

    @Override
    public List<ProductBatch> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductBatch save(ProductBatch t) {
        if (t.getProductBatchId().isEmpty()) {
            t.setProductBatchId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productBatchRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productBatchRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductBatch current, ProductBatch old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductBatch> findByActiveOrderByProductBatchName(Boolean active) {
        return productBatchRepo.findByActiveOrderByProductBatchNameAsc(active);
    }

    @Override
    public List<ProductBatch> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productBatchRepo.findByProductBatchName(exp[0], Boolean.TRUE);
        }
        return productBatchRepo.findByProductBatchName(exp[0], Boolean.TRUE);

    }

}
