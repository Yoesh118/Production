/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.WorkOrder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class WorkOrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(WorkOrder.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        WorkOrder item = (WorkOrder) o;    
        ValidationUtils.rejectIfEmpty(errors, "customers", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "customerContact", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "dateOrdered", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "quantity", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "cost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "product", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "product", "item.required");
        
        if (item.getDateOrdered() != null) {
            if (item.getDateOrdered().after(item.getCollectionDate())) {
                errors.rejectValue("dateOrdered", "date.after");
            }
        }
    }
}
   