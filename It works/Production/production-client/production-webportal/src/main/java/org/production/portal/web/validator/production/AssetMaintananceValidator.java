/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.AssetMaintanance;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AssetMaintananceValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(AssetMaintanance.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        AssetMaintanance item = (AssetMaintanance) o;    
        ValidationUtils.rejectIfEmpty(errors, "assetMaintananceProduct", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "assetMaintananceDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "maintananceCompany", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "cost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "companyAddress", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "companyBankDetails", "item.required");
    }
}