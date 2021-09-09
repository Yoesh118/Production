/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.business.service;

import org.production.business.domain.Company;
import org.production.business.domain.CompanyBankDetail;

/**
 *
 * @author  Rachel Makwara
 */
public interface CompanyBankDetailService extends AbstractCompanyAttrService<CompanyBankDetail> {

    public CompanyBankDetail getByCompanyAndBankAndDetail(Company company, String bank, String accountNumber);
}