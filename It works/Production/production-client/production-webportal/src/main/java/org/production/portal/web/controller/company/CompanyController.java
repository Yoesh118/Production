package org.production.portal.web.controller.company;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.Company;
import org.production.business.service.CompanyService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.CompanyValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Resource
    private CompanyService companyService;
    @Resource
    private CompanyValidator companyValidator;


    public void setUpModel(ModelMap model, Company item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Company");
        model.addAttribute("company", item);
        model.addAttribute("itemDelete", "../index.htm?type=3");
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String companyForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        Company p;
        if (id != null) {
            p = companyService.get(id);
        } else {
            p = new Company();
        }

        setUpModel(model, p);
        return "company/companyNationalForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveCompanys(@ModelAttribute("company") @Valid Company company, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        companyValidator.validate(company, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, company);
            return "company/companyNationalForm";
        }
        Company comp = companyService.save(company);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getCompanyId();
    }

    @RequestMapping(value = {"/company.list", "/"}, method = RequestMethod.GET)
    public String companyList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Company List");
        model.addAttribute("items", companyService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "admin/companyList";
    }

    @RequestMapping(value = "company.delete", method = RequestMethod.GET)
    public String getCompanysDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Company company = companyService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, company.getName(), "company.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + company.getName() + " Companys");
        return "admin/deleteItem";
    }

    @RequestMapping(value = "company.delete", method = RequestMethod.POST)
    public String deleteCompanys(@Valid ItemDeleteDTO dto) {
        companyService.delete(companyService.get(dto.getId()));
        return "redirect:company.list?type=2";
    }
}
