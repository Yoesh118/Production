/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.business.domain.production.ProcessingPlant;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProcessingPlantValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProcessingPlant.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProcessingPlant item = (ProcessingPlant) o;    
        ValidationUtils.rejectIfEmpty(errors, "processingPlantLocation", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "processingPlantDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "processingPlantName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "functionality", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "capacity", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "capacityStatus", "item.required");
    }
}