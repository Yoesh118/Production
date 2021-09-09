/*
 * Copyright 2021 yoesh.
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
package org.production.business.utils;

/**
 *
 * @author yoesh
 */
public enum Customer {

    Rachel(1), National_Foods(2), CICOSY(3), Masawara(4);

    private final Integer code;

    private Customer (Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static Customer  get(Integer code) {
        switch (code) {
            case 1:
                return Rachel;
            case 2:
                return National_Foods;
            case 3:
                return CICOSY;
            case 4:
                return Masawara;
            default:
                throw new IllegalArgumentException("Parameter does not exist :" + code);
        }
    }

    public String getName() {
        return StringUtils.toCamelCase2(super.name());
    }
}
