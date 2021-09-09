/*
 * Copyright 2015 Edward Zengeni.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.production.business.repo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author  Rachel Makwara
 * @param <T> implementing name description based interface
 * @param <ID> primary key identifier
 */
public interface AbstractNameDescRepo <T, ID extends Serializable> extends AbstractRepo<T, ID> {
    
    public T findByName(String name);
    
    public List<T> findByActiveOrderByNameAsc(Boolean active);
   
}