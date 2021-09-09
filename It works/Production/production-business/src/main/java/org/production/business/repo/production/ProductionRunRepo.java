/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductionRun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductionRunRepo extends AbstractRepo<ProductionRun, String> {

    @Override
    public List<ProductionRun> findAll();

    public List<ProductionRun> findByActiveOrderByProductionRunDescriptionAsc(Boolean active);

    @Query("from ProductionRun e  where  e.active=:active and (e.productionRunDescription Like :productionRunDescription%  or e.productionRunId Like :productionRunDescription%) order by e.productionRunDescription ASC")
    public List<ProductionRun> findByProductionRunDescription(@Param("productionRunDescription") String productionRunDescription, @Param("active") Boolean active);
}
