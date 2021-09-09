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

package org.production.portal.web.converter.production;

import org.production.portal.web.converter.*;
import javax.annotation.Resource;
import org.production.business.domain.production.Material;
import org.production.business.service.production.MaterialService;
import org.springframework.core.convert.converter.Converter;

/**
 * @author  Rachel Makwara
 */
public class MaterialConverter implements Converter<String, Material> {
    
    @Resource
    private MaterialService materialService;

    @Override
    public Material convert(String s) {
        if(s.equals("")) return null;
        return materialService.get(String.valueOf(s));
    }
    
}