/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import java.util.List;
import org.production.business.domain.CompanyDirector;

/**
 *
 * @author  Rachel Makwara
 */
public interface CompanyDirectorService extends GenericService<CompanyDirector> {


    public List<CompanyDirector> getActive();
}