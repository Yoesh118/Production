/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ProductBatch;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductBatchValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductBatch.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductBatch item = (ProductBatch) o;    
        ValidationUtils.rejectIfEmpty(errors, "productBatchName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchQuantity", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
    }
}