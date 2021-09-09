/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.Material;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MaterialValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(Material.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Material item = (Material) o;    
        ValidationUtils.rejectIfEmpty(errors, "name", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "materialDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "materialCost", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "companyName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "contactDetails", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "quantity", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "companyAddress", "item.required");
    }
}
   