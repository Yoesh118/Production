/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.IncidentCost;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class IncidentCostValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(IncidentCost.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        IncidentCost item = (IncidentCost) o; 
        ValidationUtils.rejectIfEmpty(errors, "repairCompany", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "companyDetails", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "totalCost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "deadline", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "paymentDate", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "workIncident.workIncidentDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "shortfall", "item.required");
    }
}
