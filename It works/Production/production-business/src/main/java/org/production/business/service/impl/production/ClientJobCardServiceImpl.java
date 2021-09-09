/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.annotation.Resource;
import org.production.business.domain.production.ClientJobCard;
import org.production.business.repo.production.ClientJobCardRepo;
import org.production.business.service.production.ClientJobCardService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("clientJobCardService")
public class ClientJobCardServiceImpl implements ClientJobCardService {

    @Resource
    private ClientJobCardRepo clientJobCardRepo;
    @Resource
    private UserService userService;

    @Override
    public List<ClientJobCard> getAll() {
        return clientJobCardRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public ClientJobCard get(String id) {

        return clientJobCardRepo.findOne(id);
    }

    @Override
    public void delete(ClientJobCard t) {
        if (t.getClientJobCardId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        clientJobCardRepo.save(t);
    }

    @Override
    public List<ClientJobCard> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientJobCard save(ClientJobCard t) {
        if (t.getClientJobCardId().isEmpty()) {
            t.setClientJobCardId(UUIDGen.generateUUID());
            t.setCardNo("RR" + getCardNo());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return clientJobCardRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return clientJobCardRepo.save(t);
    }
    
    private static String getCardNo() {
        int randomInt = new Random().nextInt();
        randomInt = randomInt < 0 ? randomInt * -1 : randomInt;
        String string = randomInt + "";

        if (string.length() > 8) {
            string = string.substring(0, 8);
        } else if (string.length() < 8) {
            do {
                string = "0" + string;
            } while (string.length() < 8);
        }
        return string;
    }

    @Override
    public Boolean checkDuplicate(ClientJobCard current, ClientJobCard old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (clientJobCardRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (clientJobCardRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
