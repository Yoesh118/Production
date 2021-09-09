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
import org.production.business.domain.production.AssetJobCard;
import org.production.business.repo.production.AssetJobCardRepo;
import org.production.business.service.production.AssetJobCardService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("assetJobCardService")
public class AssetJobCardServiceImpl implements AssetJobCardService {

    @Resource
    private AssetJobCardRepo assetJobCardRepo;
    @Resource
    private UserService userService;

    @Override
    public List<AssetJobCard> getAll() {
        return assetJobCardRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public AssetJobCard get(String id) {

        return assetJobCardRepo.findOne(id);
    }

    @Override
    public void delete(AssetJobCard t) {
        if (t.getAssetJobCardId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        assetJobCardRepo.save(t);
    }

    @Override
    public List<AssetJobCard> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AssetJobCard save(AssetJobCard t) {
        if (t.getAssetJobCardId().isEmpty()) {
            t.setAssetJobCardId(UUIDGen.generateUUID());
            t.setCardNo("RR" + getCardNo());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return assetJobCardRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return assetJobCardRepo.save(t);
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
    public Boolean checkDuplicate(AssetJobCard current, AssetJobCard old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (assetJobCardRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (assetJobCardRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
