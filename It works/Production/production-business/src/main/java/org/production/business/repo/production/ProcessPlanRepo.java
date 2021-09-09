/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProcessPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProcessPlanRepo extends AbstractRepo<ProcessPlan, String> {

    @Override
    public List<ProcessPlan> findAll();

    public List<ProcessPlan> findByActiveOrderByProcessPlanIdAsc(Boolean active);

    @Query("from ProcessPlan e  where  e.active=:active and (e.processPlanId Like :processPlanId%) order by e.processPlanId ASC")
    public List<ProcessPlan> findByProcessPlanId(@Param("processPlanId") String processPlanId, @Param("active") Boolean active);
}
