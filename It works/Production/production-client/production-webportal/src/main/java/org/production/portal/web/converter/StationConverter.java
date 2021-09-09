/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.converter;

import javax.annotation.Resource;
import org.production.business.domain.Station;
import org.production.business.service.StationService;
import org.springframework.core.convert.converter.Converter;

public class StationConverter implements Converter<String, Station> {

    @Resource
    private StationService stationService;

    @Override
    public Station convert(String s) {
        if(s.equals("")) return null;
        return stationService.get(s);
    }
}