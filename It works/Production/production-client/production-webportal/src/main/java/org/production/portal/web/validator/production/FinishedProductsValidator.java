/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.FinishedProducts;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FinishedProductsValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(FinishedProducts.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FinishedProducts item = (FinishedProducts) o;    
        ValidationUtils.rejectIfEmpty(errors, "product", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "product", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productNo", "item.required");
    }
}