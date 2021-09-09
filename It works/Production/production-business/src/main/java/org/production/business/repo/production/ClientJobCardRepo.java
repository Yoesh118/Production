/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.ClientJobCard;

/*
 * @author  Rachel Makwara
 */
public interface ClientJobCardRepo extends AbstractNameDescRepo<ClientJobCard, String> {

    @Override
    public List<ClientJobCard>findAll();
    
    @Override
    public ClientJobCard findByName(String name);
}
