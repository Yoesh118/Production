/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.WorkIncident;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class WorkIncidentValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(WorkIncident.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        WorkIncident item = (WorkIncident) o;    
        ValidationUtils.rejectIfEmpty(errors, "workIncidentName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "workIncidentDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "date", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
    }
}