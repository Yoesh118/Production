/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import org.production.business.domain.Company;
import org.production.business.domain.CompanyContact;
import org.production.business.domain.ContactType;

/**
 *
 * @author  Rachel Makwara
 */
public interface CompanyContactService extends AbstractCompanyAttrService<CompanyContact> {

    public CompanyContact getByContactTypeAndContactDetail(Company company, ContactType contactType, String contactDetail);
}
