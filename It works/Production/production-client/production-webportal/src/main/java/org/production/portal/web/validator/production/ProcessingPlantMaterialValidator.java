/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ProcessingPlantMaterial;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProcessingPlantMaterialValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProcessingPlantMaterial.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProcessingPlantMaterial item = (ProcessingPlantMaterial) o;    
        ValidationUtils.rejectIfEmpty(errors, "material", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "processingPlantMaterialDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "dateAcquired", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "quantity", "item.required");
    }
}
   