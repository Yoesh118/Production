/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.CustomerLevel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerLevelValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(CustomerLevel.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CustomerLevel item = (CustomerLevel) o;    
        ValidationUtils.rejectIfEmpty(errors, "name", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "description", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "privilege", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "discount", "item.required");
        
    }
}