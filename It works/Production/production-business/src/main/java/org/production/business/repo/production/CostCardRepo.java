/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.CostCard;

/*
 * @author  Rachel Makwara
 */
public interface CostCardRepo extends AbstractNameDescRepo<CostCard, String> {

    @Override
    public List<CostCard>findAll();
    
    @Override
    public CostCard findByName(String name);
}
