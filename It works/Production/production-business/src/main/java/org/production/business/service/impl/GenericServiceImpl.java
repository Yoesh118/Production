package org.production.business.service.impl;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author  Rachel Makwara
 * @param <T>
 *  
 */
public interface GenericServiceImpl<T extends Serializable> extends Serializable {
    
    public List<T> getAll();
    public T get(String id);
    public void delete(T t);
    public List<T> getPageable();
    public T save(T t);
    public Boolean checkDuplicate(T current, T old);
}