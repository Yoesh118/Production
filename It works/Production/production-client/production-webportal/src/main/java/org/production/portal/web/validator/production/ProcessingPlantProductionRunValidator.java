/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ProcessingPlantProductionRun;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProcessingPlantProductionRunValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProcessingPlantProductionRun.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProcessingPlantProductionRun item = (ProcessingPlantProductionRun) o;    
        ValidationUtils.rejectIfEmpty(errors, "processingPlantProductionRunNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "processingPlantProductionRunDescription", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "completionDate", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "startDate", "item.required");
    }
}