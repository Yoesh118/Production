/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Material;
import org.production.business.repo.production.MaterialRepo;
import org.production.business.service.production.MaterialService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("materialService")
public class MaterialServiceImpl implements MaterialService {

    @Resource
    private MaterialRepo materialRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Material> getAll() {
        return materialRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Material get(String id) {

        return materialRepo.findOne(id);
    }

    @Override
    public void delete(Material t) {
        if (t.getMaterialId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        materialRepo.save(t);
    }

    @Override
    public List<Material> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Material save(Material t) {
        if (t.getMaterialId().isEmpty()) {
            t.setMaterialId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return materialRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return materialRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Material current, Material old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (materialRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (materialRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
