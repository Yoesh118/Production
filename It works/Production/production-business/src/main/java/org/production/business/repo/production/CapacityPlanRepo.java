/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.CapacityPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface CapacityPlanRepo extends AbstractRepo<CapacityPlan, String> {

    @Override
    public List<CapacityPlan> findAll();

    public List<CapacityPlan> findByActiveOrderByCapacityPlanIdAsc(Boolean active);

    @Query("from CapacityPlan e  where  e.active=:active and (e.capacityPlanId Like :capacityPlanId%) order by e.capacityPlanId ASC")
    public List<CapacityPlan> findByCapacityPlanId(@Param("capacityPlanId") String capacityPlanId, @Param("active") Boolean active);
}
