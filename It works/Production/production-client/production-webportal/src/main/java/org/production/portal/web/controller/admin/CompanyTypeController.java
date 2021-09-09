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
import org.production.portal.web.validator.CompanyTypeValidator;
import org.production.business.domain.CompanyType;
import org.production.business.service.CompanyTypeService;
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
@RequestMapping("/admin/companyType")
public class CompanyTypeController extends BaseController{

    @Resource
    private CompanyTypeService companyTypeService;
    @Resource
    private CompanyTypeValidator companyTypeValidator;
    @Resource
    private ProvinceService provinceService;

    @RequestMapping(value = "/companyType.form", method = RequestMethod.GET)
    public String companyTypeForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit CompanyType");
        model.addAttribute("itemDelete", "companyType.list");
        model.addAttribute("provinces", provinceService.getAll());
        CompanyType p = new CompanyType();
        if (id != null) {
            p = companyTypeService.get(id);
        }
        model.addAttribute("item", p);
        return "admin/companyTypeForm";
    }

    @RequestMapping(value = "/companyType.form", method = RequestMethod.POST)
    public String saveCompanyType(@ModelAttribute("item") @Valid CompanyType companyType, BindingResult result, ModelMap model) {
        companyTypeValidator.validate(companyType, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit CompanyType");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", companyType);
            model.addAttribute("itemDelete", "companyType.list");
            return "admin/companyTypeForm";
        }
        companyTypeService.save(companyType);
        return "redirect: companyType.list?type=1";
    }

    @RequestMapping(value = {"/companyType.list", "/"}, method = RequestMethod.GET)
    public String companyTypeList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::CompanyType List");
        model.addAttribute("items", companyTypeService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "admin/companyTypeList";
    }
    
    @RequestMapping(value = "companyType.delete", method = RequestMethod.GET)
    public String getCompanyTypeDeleteForm(@RequestParam("id") String id, ModelMap model){
        CompanyType companyType = companyTypeService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, companyType.getName(), "companyType.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+companyType.getName()+" CompanyType");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "companyType.delete", method = RequestMethod.POST)
    public String deleteCompanyType(@Valid ItemDeleteDTO dto){
        companyTypeService.delete(companyTypeService.get(dto.getId()));
        return "redirect:companyType.list?type=2";
    }
}
