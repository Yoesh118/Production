/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.BatchStatus;
import org.production.business.repo.production.BatchStatusRepo;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("batchStatusService")
public class BatchStatusServiceImpl implements BatchStatusService {

    @Resource
    private BatchStatusRepo batchStatusRepo;
    @Resource
    private UserService userService;

    @Override
    public List<BatchStatus> getAll() {
        return batchStatusRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public BatchStatus get(String id) {

        return batchStatusRepo.findOne(id);
    }

    @Override
    public void delete(BatchStatus t) {
        if (t.getBatchStatusId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        batchStatusRepo.save(t);
    }

    @Override
    public List<BatchStatus> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BatchStatus save(BatchStatus t) {
        if (t.getBatchStatusId().isEmpty()) {
            t.setBatchStatusId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return batchStatusRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return batchStatusRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(BatchStatus current, BatchStatus old) {

        if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (batchStatusRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (batchStatusRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;

    }

}
