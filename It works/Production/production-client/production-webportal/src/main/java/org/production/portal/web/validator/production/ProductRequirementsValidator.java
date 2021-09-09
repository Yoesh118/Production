/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ProductRequirements;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductRequirementsValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductRequirements.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductRequirements item = (ProductRequirements) o;    
        ValidationUtils.rejectIfEmpty(errors, "product", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productRequirementsDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "qty", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "cost", "item.required");
    }
}