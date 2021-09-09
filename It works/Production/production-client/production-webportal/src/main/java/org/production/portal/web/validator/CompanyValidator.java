/*
 * Copyright 2014 Edward Zengeni.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.production.portal.web.validator;

import org.production.business.domain.Company;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author  Rachel Makwara
 */
@Component
public class CompanyValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Company.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "field.empty");
//        ValidationUtils.rejectIfEmpty(errors, "country", "item.required");
//        ValidationUtils.rejectIfEmpty(errors, "industry", "item.required");
//        ValidationUtils.rejectIfEmpty(errors, "companyStatus", "item.required");
    }
}
