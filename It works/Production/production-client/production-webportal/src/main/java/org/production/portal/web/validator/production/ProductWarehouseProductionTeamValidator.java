/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProductWarehouseProductionTeam;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductWarehouseProductionTeamValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductWarehouseProductionTeam.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductWarehouseProductionTeam item = (ProductWarehouseProductionTeam) o;    
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.teamNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamMembers", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.timeTillFree", "item.required");
    }
}