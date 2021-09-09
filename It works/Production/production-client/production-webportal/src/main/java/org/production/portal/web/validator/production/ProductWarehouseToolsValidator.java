/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProductWarehouseTools;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductWarehouseToolsValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductWarehouseTools.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductWarehouseTools item = (ProductWarehouseTools) o;    
       ValidationUtils.rejectIfEmpty(errors, "status", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamName", "item.required");
       ValidationUtils.rejectIfEmpty(errors, "userLocation", "item.required");
    }
}  