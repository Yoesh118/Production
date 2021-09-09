package org.production.portal.web.controller.company;

import javax.annotation.Resource;
import org.production.business.domain.Company;
import org.production.business.service.CompanyBankDetailService;
import org.production.business.service.CompanyContactService;
import org.production.business.service.CompanyService;
import org.production.portal.util.AppMessage;
import org.production.portal.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/company/dashboard")
public class CompanyDashboardController extends BaseController {

    @Resource
    private CompanyService companyService;
    @Resource
    private CompanyBankDetailService companyBankDetailService;
    @Resource
    private CompanyContactService companyContactService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String companyProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        Company company = companyService.get(id);
        model.addAttribute("pageTitle", appPrefix + company.getName() + "'s Dashboard");
        model.addAttribute("company", company);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        model.addAttribute("banks", companyBankDetailService.getByCompany(company));
        model.addAttribute("contacts", companyContactService.getByCompany(company));
        return "company/companyDashboard";
    }
}
