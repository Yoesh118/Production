/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.SupportingDocument;
import org.production.business.repo.SupportingDocumentRepo;
import org.production.business.service.SupportingDocumentService;
import org.production.business.service.UserService;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository
public class SupportingDocumentServiceImpl implements SupportingDocumentService {

    @Resource
    private SupportingDocumentRepo supportingDocumentRepo;
    @Resource
    private UserService userService;

    @Override
    public List<SupportingDocument> getAll() {
        return supportingDocumentRepo.findByActiveOrderByNameAsc(Boolean.TRUE);

    }

    @Override
    public SupportingDocument get(String id) {

        return supportingDocumentRepo.findOne(id);
    }

    @Override
    public void delete(SupportingDocument t) {
        if (t.getSupportingDocumentId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        supportingDocumentRepo.save(t);
    }

    @Override
    public List<SupportingDocument> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SupportingDocument save(SupportingDocument t) {
        if (t.getSupportingDocumentId().isEmpty()) {
            t.setSupportingDocumentId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return supportingDocumentRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return supportingDocumentRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(SupportingDocument current, SupportingDocument old) {
          if (current.getId() != null) {
            /**
             * @param current is in existence
             */
            if (!current.getName().equals(old.getName())) {
                if (supportingDocumentRepo.findByName(current.getName()) != null) {
                    return true;
                }
            }
        } else if (current.getId() == null) {

            if (supportingDocumentRepo.findByName(current.getName()) != null) {
                return true;
            }

        }

        return false;
    }
    

    @Override
    public List<SupportingDocument> getActive() {
        return supportingDocumentRepo.findByActiveOrderByNameAsc(Boolean.TRUE);
    }

}
