/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.Customers;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomersValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(Customers.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customers item = (Customers) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "contactDetails", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "customersAddress", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "nationality", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "years", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "orders", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "customerLevel", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "loyaltyDiscount", "item.required");
    }
}
