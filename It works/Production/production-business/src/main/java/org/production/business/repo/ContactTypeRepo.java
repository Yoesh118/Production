/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo;

import java.util.List;
import org.production.business.domain.ContactType;

/*
 * @author  Rachel Makwara
 */
public interface ContactTypeRepo extends AbstractNameDescRepo<ContactType, String> {

    @Override
    public List<ContactType>findAll();
    
    @Override
    public ContactType findByName(String name);
}
