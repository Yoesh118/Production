/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.ProcurementCost;
import org.production.business.repo.production.ProcurementCostRepo;
import org.production.business.service.production.ProcurementCostService;
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
@Repository("procurementCostService")
public class ProcurementCostServiceImpl implements ProcurementCostService {

    @Resource
    private ProcurementCostRepo procurementCostRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ProcurementCost> getAll() {
        return procurementCostRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ProcurementCost get(String id) {
        return procurementCostRepo.findOne(id);
    }

    @Override
    public void delete(ProcurementCost t) {
        if (t.getProcurementCostId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        procurementCostRepo.save(t);

    }

    @Override
    public List<ProcurementCost> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcurementCost save(ProcurementCost t) {
        if (t.getProcurementCostId().isEmpty()) {
            t.setProcurementCostId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return procurementCostRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return procurementCostRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ProcurementCost current, ProcurementCost old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcurementCost> findByActiveOrderByItem(Boolean active) {
        return procurementCostRepo.findByActiveOrderByItemAsc(active);
    }

    @Override
    public List<ProcurementCost> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return procurementCostRepo.findByActiveOrderByItemAsc(Boolean.TRUE);
        }
        return procurementCostRepo.findByActiveOrderByItemAsc(Boolean.TRUE);

    }

    @Override
    public List<ProcurementCost> getByProductionCost(ProductionCost productionCost) {
        return procurementCostRepo.findByActiveOrderByItemAsc(Boolean.TRUE);
    }

    @Override
    public List<ProcurementCost> getByProductionCost(ProductionCost productionCost, String procurementCostNo) {
       return procurementCostRepo.findByItem(productionCost, procurementCostNo);
    }
}
