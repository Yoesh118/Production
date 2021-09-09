/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ProductionTeam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author  Rachel Makwara
 */
public interface ProductionTeamRepo extends AbstractRepo<ProductionTeam, String> {

    @Override
    public List<ProductionTeam> findAll();

    public List<ProductionTeam> findByActiveOrderByProductionTeamDescriptionAsc(Boolean active);

    @Query("from ProductionTeam e  where  e.active=:active and (e.productionTeamDescription Like :productionTeamDescription%  or e.productionTeamId Like :productionTeamDescription%) order by e.productionTeamDescription ASC")
    public List<ProductionTeam> findByProductionTeamDescription(@Param("productionTeamDescription") String productionTeamDescription, @Param("active") Boolean active);
}
