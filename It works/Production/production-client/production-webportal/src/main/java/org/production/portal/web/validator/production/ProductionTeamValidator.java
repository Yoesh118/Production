/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProductionTeam;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductionTeamValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProductionTeam.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductionTeam item = (ProductionTeam) o;    
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.teamNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamMembers", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productWarehouseProductionTeamDuties", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.timeTillFree", "item.required");
    }
}
   