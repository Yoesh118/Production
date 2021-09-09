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
import org.production.business.domain.production.IncidentCost;
import org.production.business.repo.production.IncidentCostRepo;
import org.production.business.service.production.IncidentCostService;
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
@Repository("incidentCostService")
public class IncidentCostServiceImpl implements IncidentCostService {

    @Resource
    private IncidentCostRepo incidentCostRepo;
    @Resource
    private UserService userService;

    @Override
    public List<IncidentCost> getAll() {
        return incidentCostRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public IncidentCost get(String id) {
        return incidentCostRepo.findOne(id);
    }

    @Override
    public void delete(IncidentCost t) {
        if (t.getIncidentCostId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        incidentCostRepo.save(t);

    }

    @Override
    public List<IncidentCost> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IncidentCost save(IncidentCost t) {
        if (t.getIncidentCostId().isEmpty()) {
            t.setIncidentCostId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return incidentCostRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return incidentCostRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(IncidentCost current, IncidentCost old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IncidentCost> findByActiveOrderByCompanyDetails(Boolean active) {
        return incidentCostRepo.findByActiveOrderByCompanyDetailsAsc(active);
    }

    @Override
    public List<IncidentCost> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return incidentCostRepo.findByActiveOrderByCompanyDetailsAsc(Boolean.TRUE);
        }
        return incidentCostRepo.findByActiveOrderByCompanyDetailsAsc(Boolean.TRUE);

    }

    @Override
    public List<IncidentCost> getByProductionCost(ProductionCost productionCost) {
        return incidentCostRepo.findByActiveOrderByCompanyDetailsAsc(Boolean.TRUE);
    }

    @Override
    public List<IncidentCost> getByProductionCost(ProductionCost productionCost, String companyDetails) {
       return incidentCostRepo.findByCompanyDetails(productionCost, companyDetails);
    }
}
