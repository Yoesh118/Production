/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.repo;

import org.production.business.domain.User;

/**
 *
 * @author  Rachel Makwara
 */
public interface UserRepo extends AbstractNameDescRepo<User, String> {
    
    public User findByUsername(String name);
}
