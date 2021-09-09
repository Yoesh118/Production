/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductionTeam;
import org.production.business.repo.production.ProductionTeamRepo;
import org.production.business.service.production.ProductionTeamService;
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
@Repository("productionTeamService")
public class ProductionTeamServiceImpl implements ProductionTeamService {

    @Resource
    private ProductionTeamRepo productionTeamRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProductionTeam> getAll() {
        return productionTeamRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProductionTeam get(String id) {
        return productionTeamRepo.findOne(id);
    }

    @Override
    public void delete(ProductionTeam t) {
        if (t.getProductionTeamId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        productionTeamRepo.save(t);

    }

    @Override
    public List<ProductionTeam> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductionTeam save(ProductionTeam t) {
        if (t.getProductionTeamId().isEmpty()) {
            t.setProductionTeamId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return productionTeamRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return productionTeamRepo.save(t);
    }

       @Override
    public Boolean checkDuplicate(ProductionTeam current, ProductionTeam old) {
          if (current.getProductionTeamId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getProductionTeamName().equals(old.getProductionTeamName())) {
                if (productionTeamRepo.findByProductionTeamDescription(current.getProductionTeamName(), Boolean.TRUE) != null) {
                    return true;
                }
            }
        } else if (current.getProductionTeamId() == null) {

            if (productionTeamRepo.findByProductionTeamDescription(current.getProductionTeamName(), Boolean.TRUE) != null) {
                return true;
            }

        }

        return false;
    }
    
    

    @Override
    public List<ProductionTeam> getActive() {
        return productionTeamRepo.findByActiveOrderByProductionTeamDescriptionAsc(Boolean.TRUE);
    }

}
