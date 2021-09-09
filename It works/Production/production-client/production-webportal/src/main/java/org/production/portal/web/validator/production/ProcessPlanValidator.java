/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator.production;

import org.production.portal.web.validator.*;
import org.production.business.domain.production.ProcessPlan;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProcessPlanValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(ProcessPlan.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProcessPlan item = (ProcessPlan) o;    
        ValidationUtils.rejectIfEmpty(errors, "OrderNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "processStages", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "stageNo", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "description", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "batchStatus", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "productWarehouse.warehouseName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "processingPlant.processingPlantName", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "startDate", "item.required");
        ValidationUtils.rejectIfEmpty(errors, "endDate", "item.required");
    }
}