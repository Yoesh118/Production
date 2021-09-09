package org.production.business.service;

import java.util.List;
import org.production.business.domain.User;
import org.production.business.domain.UserRole;

/**
 *
 * @author  Rachel Makwara
 */
public interface UserService extends GenericService<User> {

    public User findByUserName(String name);

    public List<UserRole> getRoles();
    
    public User getUserByUserName(String username);
    
    String getCurrentUsername();
    
    User getCurrentUser();
    
    public User changePassword(User t);
}
