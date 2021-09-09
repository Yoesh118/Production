/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Tools;
import org.production.business.repo.production.ToolsRepo;
import org.production.business.service.production.ToolsService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("toolsService")
public class ToolsServiceImpl implements ToolsService {

    @Resource
    private ToolsRepo toolsRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Tools> getAll() {
        return toolsRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public Tools get(String id) {

        return toolsRepo.findOne(id);
    }

    @Override
    public void delete(Tools t) {
        if (t.getToolId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        toolsRepo.save(t);
    }

    @Override
    public List<Tools> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tools save(Tools t) {
        if (t.getToolId().isEmpty()) {
            t.setToolId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return toolsRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return toolsRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Tools current, Tools old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (toolsRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (toolsRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
