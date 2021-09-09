/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ProductWarehouse;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductWarehouseValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductWarehouse.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductWarehouse item = (ProductWarehouse) o;    
        ValidationUtils.rejectIfEmpty(errors, "warehouseName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "warehouseDescription", "item.required");
    }
}