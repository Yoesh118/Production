/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.AssetMaintanance;
import org.production.business.repo.production.AssetMaintananceRepo;
import org.production.business.service.production.AssetMaintananceService;
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
@Repository("assetMaintananceService")
public class AssetMaintananceServiceImpl implements AssetMaintananceService {

    @Resource
    private AssetMaintananceRepo assetMaintananceRepo;
    @Resource
    private UserService userService;

    @Override
    public List<AssetMaintanance> getAll() {
        return assetMaintananceRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public AssetMaintanance get(String id) {
        return assetMaintananceRepo.findOne(id);
    }

    @Override
    public void delete(AssetMaintanance t) {
        if (t.getAssetMaintananceId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        assetMaintananceRepo.save(t);

    }

    @Override
    public List<AssetMaintanance> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AssetMaintanance save(AssetMaintanance t) {
        if (t.getAssetMaintananceId().isEmpty()) {
            t.setAssetMaintananceId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return assetMaintananceRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return assetMaintananceRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(AssetMaintanance current, AssetMaintanance old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AssetMaintanance> findByActiveOrderByAssetMaintananceProduct(Boolean active) {
        return assetMaintananceRepo.findByActiveOrderByAssetMaintananceProductAsc(active);
    }

    @Override
    public List<AssetMaintanance> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return assetMaintananceRepo.findByAssetMaintananceProduct(exp[0], Boolean.TRUE);
        }
        return assetMaintananceRepo.findByAssetMaintananceProduct(exp[0], Boolean.TRUE);

    }

}
