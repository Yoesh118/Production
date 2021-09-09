/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import org.production.business.service.*;
import java.util.List;
import org.production.business.domain.production.ProductionTeam;

/**
 *
 * @author  Rachel Makwara
 */
public interface ProductionTeamService extends GenericService<ProductionTeam> {


    public List<ProductionTeam> getActive();
}