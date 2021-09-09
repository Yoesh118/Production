/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ClientMaintanance;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientMaintananceValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ClientMaintanance.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ClientMaintanance item = (ClientMaintanance) o;    
        ValidationUtils.rejectIfEmpty(errors, "clientMaintananceProduct", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "clientMaintananceDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "clientName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "companyCost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "clientCost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productionTeam.productionTeamName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
    }
}