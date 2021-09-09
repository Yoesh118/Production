/*
 * Copyright 2016 Edward Zengeni.
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
package org.production.business.util.dto;

import java.util.Date;
import org.production.business.domain.District;
import org.production.business.domain.Province;
import org.production.business.domain.Station;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author  Rachel Makwara
 */
public class PeriodBasedDTO extends SearchDTO {
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;

    public PeriodBasedDTO() {
    }

    public PeriodBasedDTO(Date startDate, Date endDate, District district, Station station, Province province) {
        super(district, station, province);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public static PeriodBasedDTO getInstance(PeriodBasedDTO dto){
        PeriodBasedDTO item = new PeriodBasedDTO(dto.getStartDate(), dto.getEndDate(), dto.getDistrict(), dto.getStation(), dto.getProvince());
        sanitizeItem(item);
        return item;
    }
    
    private static void sanitizeItem(PeriodBasedDTO dto){
        if(dto.getStation() != null){
            dto.setDistrict(null);
            dto.setProvince(null);
        }
        if(dto.getDistrict() != null){
            dto.setProvince(null);
        }
    }
}