/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import java.util.List;
import org.production.business.domain.Nationality;

/**
 *
 * @author  Rachel Makwara
 */
public interface NationalityService extends GenericService<Nationality> {


    public List<Nationality> getActive();
}