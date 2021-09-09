/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.CapacityPlan;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CapacityPlanValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(CapacityPlan.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CapacityPlan item = (CapacityPlan) o;    
        ValidationUtils.rejectIfEmpty(errors, "name", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "description", "item.required");
    }
}