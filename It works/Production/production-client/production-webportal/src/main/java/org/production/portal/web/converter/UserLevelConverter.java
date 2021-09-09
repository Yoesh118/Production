/*
 * Copyright 2015 Edward Zengeni.
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
package org.production.portal.web.converter;

import org.production.business.util.dto.UserLevel;
import org.springframework.core.convert.converter.Converter;

/**
 *
 * @author  Rachel Makwara
 */
public class UserLevelConverter implements Converter<String, UserLevel> {

    @Override
    public UserLevel convert(String s) {
        if(s.equals("")) return null;
        return UserLevel.get(Integer.valueOf(s));
    }
}