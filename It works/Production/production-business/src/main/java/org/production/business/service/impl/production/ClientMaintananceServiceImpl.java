/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.ClientMaintanance;
import org.production.business.repo.production.ClientMaintananceRepo;
import org.production.business.service.production.ClientMaintananceService;
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
@Repository("clientMaintananceService")
public class ClientMaintananceServiceImpl implements ClientMaintananceService {

    @Resource
    private ClientMaintananceRepo clientMaintananceRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ClientMaintanance> getAll() {
        return clientMaintananceRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public ClientMaintanance get(String id) {
        return clientMaintananceRepo.findOne(id);
    }

    @Override
    public void delete(ClientMaintanance t) {
        if (t.getClientMaintananceId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        clientMaintananceRepo.save(t);

    }

    @Override
    public List<ClientMaintanance> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientMaintanance save(ClientMaintanance t) {
        if (t.getClientMaintananceId().isEmpty()) {
            t.setClientMaintananceId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return clientMaintananceRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return clientMaintananceRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(ClientMaintanance current, ClientMaintanance old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClientMaintanance> findByActiveOrderByClientMaintananceProduct(Boolean active) {
        return clientMaintananceRepo.findByActiveOrderByClientMaintananceProductAsc(active);
    }

    @Override
    public List<ClientMaintanance> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return clientMaintananceRepo.findByClientMaintananceProduct(exp[0], Boolean.TRUE);
        }
        return clientMaintananceRepo.findByClientMaintananceProduct(exp[0], Boolean.TRUE);

    }

}
