/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service.impl.production;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.production.business.domain.production.Employee;
import org.production.business.repo.production.EmployeeRepo;
import org.production.business.service.production.EmployeeService;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchByNameDTO;
import org.production.business.utils.UUIDGen;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author  Rachel Makwara
 */
@Transactional(readOnly = true)
@Repository("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeRepo employeeRepo;
    @Resource
    private UserService userService;

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findByActive(Boolean.TRUE);
    }

    @Override
    public Employee get(String id) {
        return employeeRepo.findOne(id);
    }

    @Override
    public void delete(Employee t) {
        if (t.getEmployeeId().isEmpty()) {
            throw new IllegalStateException("Item to be deleted is in an inconsistent state");
        }
        t.setActive(Boolean.FALSE);
        employeeRepo.save(t);

    }

    @Override
    public List<Employee> getPageable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee save(Employee t) {
        if (t.getEmployeeId().isEmpty()) {
            t.setEmployeeId(UUIDGen.generateUUID());
            t.setCreatedBy(userService.getCurrentUser());
            t.setDateCreated(new Date());
            return employeeRepo.save(t);
        }
        t.setModifiedBy(userService.getCurrentUser());
        t.setDateModified(new Date());
        return employeeRepo.save(t);
    }

    @Override
    public Boolean checkDuplicate(Employee current, Employee old) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> findByActiveOrderByEmployeeName(Boolean active) {
        return employeeRepo.findByActiveOrderByEmployeeNameAsc(active);
    }

    @Override
    public List<Employee> search(SearchByNameDTO dto) {
        String[] exp = dto.getName();
        if (exp == null) {
            throw new IllegalArgumentException("Provide parameter for search");
        } else if (exp.length == 1) {
            return employeeRepo.findByEmployeeName(exp[0], Boolean.TRUE);
        }
        return employeeRepo.findByEmployeeName(exp[0], Boolean.TRUE);

    }

}
