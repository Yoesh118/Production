/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.Other;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OtherValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(Other.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Other item = (Other) o;  
        ValidationUtils.rejectIfEmpty(errors, "name", "item.required");  
        ValidationUtils.rejectIfEmpty(errors, "description", "item.required"); 
        ValidationUtils.rejectIfEmpty(errors, "cost", "item.required"); 
        ValidationUtils.rejectIfEmpty(errors, "datePaid", "item.required"); 
        ValidationUtils.rejectIfEmpty(errors, "deadline", "item.required"); 
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required"); 
        ValidationUtils.rejectIfEmpty(errors, "shortfall", "item.required"); 
    }
}

