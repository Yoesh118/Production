/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.validator;

import org.production.portal.util.UploadItem;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author  Rachel Makwara
 */
@Component
public class UploadItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.equals(UploadItem.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UploadItem uploadItem = (UploadItem) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "name.required");
        if(uploadItem.getFileData()==null || uploadItem.getFileData().isEmpty()){
             errors.rejectValue("fileData", "fileData.empty");
        }
    }
}
