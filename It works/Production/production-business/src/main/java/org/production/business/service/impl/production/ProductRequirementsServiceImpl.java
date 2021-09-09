/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductRequirements;
import org.production.business.repo.production.ProductRequirementsRepo;
import org.production.business.service.production.ProductRequirementsService;
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
@Repository("productRequirementsService")
public class ProductRequirementsServiceImpl implements ProductRequirementsService {

    @Resource
    private ProductRequirementsRepo productRequirementsRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductRequirements> getAll() {
        return productRequirementsRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductRequirements get(String id) {
        return productRequirementsRepo.findOne(id);
    }

    @Override
    public void delete(ProductRequirements t) {
        if (t.getProductRequirementsId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productRequirementsRepo.save(t);

    }

    @Override
    public List<ProductRequirements> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductRequirements save(ProductRequirements t) {
        if (t.getProductRequirementsId().isEmpty()) {
            t.setProductRequirementsId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productRequirementsRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productRequirementsRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductRequirements current, ProductRequirements old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductRequirements> findByActiveOrderByProductRequirementsDescription(Boolean active) {
        return productRequirementsRepo.findByActiveOrderByProductRequirementsDescriptionAsc(active);
    }

    @Override
    public List<ProductRequirements> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productRequirementsRepo.findByProductRequirementsDescription(exp[0], Boolean.TRUE);
        }
        return productRequirementsRepo.findByProductRequirementsDescription(exp[0], Boolean.TRUE);

    }

}
