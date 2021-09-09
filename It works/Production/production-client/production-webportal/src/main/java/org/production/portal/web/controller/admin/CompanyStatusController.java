/*
 * Copyright 2014 Edward Zengeni.
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
package org.production.portal.web.controller.admin;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.CompanyStatusValidator;
import org.production.business.domain.CompanyStatus;
import org.production.business.service.CompanyStatusService;
import org.production.business.service.ProvinceService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/admin/companyStatus")
public class CompanyStatusController extends BaseController{

    @Resource
    private CompanyStatusService companyStatusService;
    @Resource
    private CompanyStatusValidator companyStatusValidator;
    @Resource
    private ProvinceService provinceService;

    @RequestMapping(value = "/companyStatus.form", method = RequestMethod.GET)
    public String companyStatusForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit CompanyStatus");
        model.addAttribute("itemDelete", "companyStatus.list");
        model.addAttribute("provinces", provinceService.getAll());
        CompanyStatus p = new CompanyStatus();
        if (id != null) {
            p = companyStatusService.get(id);
        }
        model.addAttribute("item", p);
        return "admin/companyStatusForm";
    }

    @RequestMapping(value = "/companyStatus.form", method = RequestMethod.POST)
    public String saveCompanyStatus(@ModelAttribute("item") @Valid CompanyStatus companyStatus, BindingResult result, ModelMap model) {
        companyStatusValidator.validate(companyStatus, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit CompanyStatus");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", companyStatus);
            model.addAttribute("itemDelete", "companyStatus.list");
            return "admin/companyStatusForm";
        }
        companyStatusService.save(companyStatus);
        return "redirect: companyStatus.list?type=1";
    }

    @RequestMapping(value = {"/companyStatus.list", "/"}, method = RequestMethod.GET)
    public String companyStatusList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::CompanyStatus List");
        model.addAttribute("items", companyStatusService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "admin/companyStatusList";
    }
    
    @RequestMapping(value = "companyStatus.delete", method = RequestMethod.GET)
    public String getCompanyStatusDeleteForm(@RequestParam("id") String id, ModelMap model){
        CompanyStatus companyStatus = companyStatusService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, companyStatus.getName(), "companyStatus.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+companyStatus.getName()+" CompanyStatus");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "companyStatus.delete", method = RequestMethod.POST)
    public String deleteCompanyStatus(@Valid ItemDeleteDTO dto){
        companyStatusService.delete(companyStatusService.get(dto.getId()));
        return "redirect:companyStatus.list?type=2";
    }
}
