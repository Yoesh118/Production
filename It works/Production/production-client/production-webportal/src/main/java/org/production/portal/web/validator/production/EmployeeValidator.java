/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(Employee.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee item = (Employee) o;    
        ValidationUtils.rejectIfEmpty(errors, "employeeName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "employeeNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "qualification", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.teamNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamDescription", "item.required");
    }
}