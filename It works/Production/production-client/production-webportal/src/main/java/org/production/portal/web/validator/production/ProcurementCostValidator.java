/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProcurementCost;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProcurementCostValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProcurementCost.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProcurementCost item = (ProcurementCost) o;  
        ValidationUtils.rejectIfEmpty(errors, "item", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "unitCost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "qty", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "procurementDate", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "deadline", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "shortfall", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
    }
}

 