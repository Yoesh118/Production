/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.MaintananceTeam;
import org.production.business.repo.production.MaintananceTeamRepo;
import org.production.business.service.production.MaintananceTeamService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("maintananceTeamService")
public class MaintananceTeamServiceImpl implements MaintananceTeamService {

    @Resource
    private MaintananceTeamRepo maintananceTeamRepo;
    @Resource
    private UserService userService;

    @Override
    public List<MaintananceTeam> getAll() {
        return maintananceTeamRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public MaintananceTeam get(String id) {

        return maintananceTeamRepo.findOne(id);
    }

    @Override
    public void delete(MaintananceTeam t) {
        if (t.getMaintananceTeamId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        maintananceTeamRepo.save(t);
    }

    @Override
    public List<MaintananceTeam> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaintananceTeam save(MaintananceTeam t) {
        if (t.getMaintananceTeamId().isEmpty()) {
            t.setMaintananceTeamId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return maintananceTeamRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return maintananceTeamRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(MaintananceTeam current, MaintananceTeam old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (maintananceTeamRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (maintananceTeamRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
