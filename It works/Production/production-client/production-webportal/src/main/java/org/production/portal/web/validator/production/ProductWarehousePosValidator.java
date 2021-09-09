/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProductWarehousePos;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductWarehousePosValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductWarehousePos.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductWarehousePos item = (ProductWarehousePos) o;    
        ValidationUtils.rejectIfEmpty(errors, "orderNo", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
    }
}