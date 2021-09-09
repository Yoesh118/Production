/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.WorkOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface WorkOrderRepo extends AbstractRepo<WorkOrder, String> {

    @Override
    public List<WorkOrder> findAll();

    public List<WorkOrder> findByActiveOrderByWorkOrderIdAsc(Boolean active);

    @Query("from WorkOrder e  where  e.active=:active and (e.workOrderId Like :workOrderId%) order by e.workOrderId ASC")
    public List<WorkOrder> findByWorkOrderId(@Param("workOrderId") String workOrderId, @Param("active") Boolean active);
}
