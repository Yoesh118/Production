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
import org.production.business.domain.production.WorkOrder;
import org.production.business.repo.production.WorkOrderRepo;
import org.production.business.service.production.WorkOrderService;
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
@Repository("workOrderService")
public class WorkOrderServiceImpl implements WorkOrderService {

    @Resource
    private WorkOrderRepo workOrderRepo;
    @Resource
    private UserService userService;

    @Override
    public List<WorkOrder> getAll() {
        return workOrderRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public WorkOrder get(String id) {
        return workOrderRepo.findOne(id);
    }

    @Override
    public void delete(WorkOrder t) {
        if (t.getWorkOrderId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        workOrderRepo.save(t);

    }

    @Override
    public List<WorkOrder> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WorkOrder save(WorkOrder t) {
        if (t.getWorkOrderId().isEmpty()) {
            t.setWorkOrderId(UUIDGen.generateUUID());
            t.setWorkOrderNo(getWorkOrderNo()+"RR"+getWorkOrderNo());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return workOrderRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return workOrderRepo.save(t);
    }
    
    private static String getWorkOrderNo() {
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
    public Boolean checkDuplicate(WorkOrder current, WorkOrder old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WorkOrder> findByActiveOrderByWorkOrderId(Boolean active) {
        return workOrderRepo.findByActiveOrderByWorkOrderIdAsc(active);
    }

    @Override
    public List<WorkOrder> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return workOrderRepo.findByWorkOrderId(exp[0], Boolean.TRUE);
        }
        return workOrderRepo.findByWorkOrderId(exp[0], Boolean.TRUE);

    }

}
