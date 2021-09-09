/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import java.util.List;
import org.production.business.domain.District;
import org.production.business.domain.Province;

/**
 *
 * @author  Rachel Makwara
 */
public interface DistrictService extends GenericService<District> {

    public List<District> getDistrictByProvince(Province province);

    public List<District> getActive();
}