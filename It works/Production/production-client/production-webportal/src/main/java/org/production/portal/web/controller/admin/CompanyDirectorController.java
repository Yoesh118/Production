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
import org.production.portal.web.validator.CompanyDirectorValidator;
import org.production.business.domain.CompanyDirector;
import org.production.business.service.CompanyDirectorService;
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
@RequestMapping("/admin/companyDirector")
public class CompanyDirectorController extends BaseController{

    @Resource
    private CompanyDirectorService companyDirectorService;
    @Resource
    private CompanyDirectorValidator companyDirectorValidator;
    @Resource
    private ProvinceService provinceService;

    @RequestMapping(value = "/companyDirector.form", method = RequestMethod.GET)
    public String companyDirectorForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit CompanyDirector");
        model.addAttribute("itemDelete", "companyDirector.list");
        model.addAttribute("provinces", provinceService.getAll());
        CompanyDirector p = new CompanyDirector();
        if (id != null) {
            p = companyDirectorService.get(id);
        }
        model.addAttribute("item", p);
        return "admin/companyDirectorForm";
    }

    @RequestMapping(value = "/companyDirector.form", method = RequestMethod.POST)
    public String saveCompanyDirector(@ModelAttribute("item") @Valid CompanyDirector companyDirector, BindingResult result, ModelMap model) {
        companyDirectorValidator.validate(companyDirector, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit CompanyDirector");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", companyDirector);
            model.addAttribute("itemDelete", "companyDirector.list");
            return "admin/companyDirectorForm";
        }
        companyDirectorService.save(companyDirector);
        return "redirect: companyDirector.list?type=1";
    }

    @RequestMapping(value = {"/companyDirector.list", "/"}, method = RequestMethod.GET)
    public String companyDirectorList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::CompanyDirector List");
        model.addAttribute("items", companyDirectorService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "admin/companyDirectorList";
    }
    
    @RequestMapping(value = "companyDirector.delete", method = RequestMethod.GET)
    public String getCompanyDirectorDeleteForm(@RequestParam("id") String id, ModelMap model){
        CompanyDirector companyDirector = companyDirectorService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, companyDirector.getName(), "companyDirector.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+companyDirector.getName()+" CompanyDirector");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "companyDirector.delete", method = RequestMethod.POST)
    public String deleteCompanyDirector(@Valid ItemDeleteDTO dto){
        companyDirectorService.delete(companyDirectorService.get(dto.getId()));
        return "redirect:companyDirector.list?type=2";
    }
}
