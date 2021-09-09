/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import java.util.List;
import org.production.business.domain.District;
import org.production.business.domain.Station;

/**
 *
 * @author  Rachel Makwara
 */
public interface StationService extends GenericService<Station> {
    
    public List<Station> getByDistrict(District district);
}