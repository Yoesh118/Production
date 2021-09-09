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
import org.production.business.domain.production.CostCard;
import org.production.business.repo.production.CostCardRepo;
import org.production.business.service.production.CostCardService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("costCardService")
public class CostCardServiceImpl implements CostCardService {

    @Resource
    private CostCardRepo costCardRepo;
    @Resource
    private UserService userService;

    @Override
    public List<CostCard> getAll() {
        return costCardRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public CostCard get(String id) {

        return costCardRepo.findOne(id);
    }

    @Override
    public void delete(CostCard t) {
        if (t.getCostCardId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        costCardRepo.save(t);
    }

    @Override
    public List<CostCard> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CostCard save(CostCard t) {
        if (t.getCostCardId().isEmpty()) {
            t.setCostCardId(UUIDGen.generateUUID());
             t.setCostCardNo("RR" + getCostCardNo());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return costCardRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return costCardRepo.save(t);
    }
    
     private static String getCostCardNo() {
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
    public Boolean checkDuplicate(CostCard current, CostCard old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (costCardRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (costCardRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
