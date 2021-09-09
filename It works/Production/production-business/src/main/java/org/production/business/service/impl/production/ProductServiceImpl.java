/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Product;
import org.production.business.repo.production.ProductRepo;
import org.production.business.service.production.ProductService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("productService")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepo productRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Product> getAll() {
        return productRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Product get(String id) {

        return productRepo.findOne(id);
    }

    @Override
    public void delete(Product t) {
        if (t.getProductId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productRepo.save(t);
    }

    @Override
    public List<Product> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product save(Product t) {
        if (t.getProductId().isEmpty()) {
            t.setProductId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Product current, Product old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (productRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (productRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
