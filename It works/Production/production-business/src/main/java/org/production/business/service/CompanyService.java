/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import java.util.List;
import org.production.business.domain.Company;
import org.production.business.util.dto.SearchByNameDTO;

/**
 *
 * @author Edward Zengeni
 */
public interface CompanyService extends GenericService<Company> {

    public List<Company> findByActiveOrderByName(Boolean active);

    public List<Company> search(SearchByNameDTO dto);

}
