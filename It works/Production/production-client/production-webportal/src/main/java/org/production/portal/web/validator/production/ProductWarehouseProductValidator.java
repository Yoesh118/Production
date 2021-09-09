/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProductWarehouseProduct;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductWarehouseProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductWarehouseProduct.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductWarehouseProduct item = (ProductWarehouseProduct) o;    
        ValidationUtils.rejectIfEmpty(errors, "product", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "product.productNo", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "product.description", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "status", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "qty", "item.required");
   }
}
    