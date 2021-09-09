/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProductWarehouseMachinery;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductWarehouseMachineryValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductWarehouseMachinery.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductWarehouseMachinery item = (ProductWarehouseMachinery) o;    
        
        ValidationUtils.rejectIfEmpty(errors, "machinery", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "machinery", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "machinery", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "machinery", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "machineStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "userStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "userLocation", "item.required");
    }
}

  
  