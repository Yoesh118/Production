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
import org.production.business.domain.production.ProductWarehouseProductionTeam;
import org.production.business.repo.production.ProductWarehouseProductionTeamRepo;
import org.production.business.service.production.ProductWarehouseProductionTeamService;
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
@Repository("productWarehouseProductionTeamService")
public class ProductWarehouseProductionTeamServiceImpl implements ProductWarehouseProductionTeamService {

    @Resource
    private ProductWarehouseProductionTeamRepo productWarehouseProductionTeamRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductWarehouseProductionTeam> getAll() {
        return productWarehouseProductionTeamRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductWarehouseProductionTeam get(String id) {
        return productWarehouseProductionTeamRepo.findOne(id);
    }

    @Override
    public void delete(ProductWarehouseProductionTeam t) {
        if (t.getProductWarehouseProductionTeamId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productWarehouseProductionTeamRepo.save(t);

    }

    @Override
    public List<ProductWarehouseProductionTeam> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductWarehouseProductionTeam save(ProductWarehouseProductionTeam t) {
        if (t.getProductWarehouseProductionTeamId().isEmpty()) {
            t.setProductWarehouseProductionTeamId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productWarehouseProductionTeamRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productWarehouseProductionTeamRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProductWarehouseProductionTeam current, ProductWarehouseProductionTeam old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductWarehouseProductionTeam> findByActiveOrderByProductWarehouseProductionTeamNo(Boolean active) {
        return productWarehouseProductionTeamRepo.findByActiveOrderByProductWarehouseProductionTeamNoAsc(active);
    }

    @Override
    public List<ProductWarehouseProductionTeam> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return productWarehouseProductionTeamRepo.findByActiveOrderByProductWarehouseProductionTeamNoAsc(Boolean.TRUE);
        }
        return productWarehouseProductionTeamRepo.findByActiveOrderByProductWarehouseProductionTeamNoAsc(Boolean.TRUE);

    }

    @Override
    public List<ProductWarehouseProductionTeam> getByProductWarehouse(ProductWarehouse productWarehouse) {
        return productWarehouseProductionTeamRepo.findByActiveOrderByProductWarehouseProductionTeamNoAsc(Boolean.TRUE);
    }

    @Override
    public List<ProductWarehouseProductionTeam> getByProductWarehouse(ProductWarehouse productWarehouse, String productWarehouseProductionTeamNo) {
       return productWarehouseProductionTeamRepo.findByProductWarehouseProductionTeamNo(productWarehouse, productWarehouseProductionTeamNo);
    }

}
