/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo.production;

import org.production.business.repo.*;
import java.util.List;
import org.production.business.domain.production.AssetJobCard;

/*
 * @author  Rachel Makwara
 */
public interface AssetJobCardRepo extends AbstractNameDescRepo<AssetJobCard, String> {

    @Override
    public List<AssetJobCard>findAll();
    
    @Override
    public AssetJobCard findByName(String name);
}
