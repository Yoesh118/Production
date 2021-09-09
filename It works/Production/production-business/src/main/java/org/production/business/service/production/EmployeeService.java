/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.production;

import org.production.business.service.*;
import java.util.List;
import org.production.business.domain.production.Employee;
import org.production.business.util.dto.SearchByNameDTO;

/**
 * @author  Rachel Makwara
 */
public interface EmployeeService extends GenericService<Employee> {

    public List<Employee> findByActiveOrderByEmployeeName(Boolean active);
    public List<Employee> search(SearchByNameDTO dto);
}
