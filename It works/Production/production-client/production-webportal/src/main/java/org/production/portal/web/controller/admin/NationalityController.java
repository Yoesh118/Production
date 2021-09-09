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
import org.production.portal.web.validator.NationalityValidator;
import org.production.business.domain.Nationality;
import org.production.business.service.NationalityService;
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
@RequestMapping("/admin/nationality")
public class NationalityController extends BaseController{

    @Resource
    private NationalityService nationalityService;
    @Resource
    private NationalityValidator nationalityValidator;
    @Resource
    private ProvinceService provinceService;

    @RequestMapping(value = "/nationality.form", method = RequestMethod.GET)
    public String nationalityForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Nationality");
        model.addAttribute("itemDelete", "nationality.list");
        model.addAttribute("provinces", provinceService.getAll());
        Nationality p = new Nationality();
        if (id != null) {
            p = nationalityService.get(id);
        }
        model.addAttribute("item", p);
        return "admin/nationalityForm";
    }

    @RequestMapping(value = "/nationality.form", method = RequestMethod.POST)
    public String saveNationality(@ModelAttribute("item") @Valid Nationality nationality, BindingResult result, ModelMap model) {
        nationalityValidator.validate(nationality, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Nationality");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", nationality);
            model.addAttribute("itemDelete", "nationality.list");
            return "admin/nationalityForm";
        }
        nationalityService.save(nationality);
        return "redirect: nationality.list?type=1";
    }

    @RequestMapping(value = {"/nationality.list", "/"}, method = RequestMethod.GET)
    public String nationalityList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Nationality List");
        model.addAttribute("items", nationalityService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "admin/nationalityList";
    }
    
    @RequestMapping(value = "nationality.delete", method = RequestMethod.GET)
    public String getNationalityDeleteForm(@RequestParam("id") String id, ModelMap model){
        Nationality nationality = nationalityService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, nationality.getName(), "nationality.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+nationality.getName()+" Nationality");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "nationality.delete", method = RequestMethod.POST)
    public String deleteNationality(@Valid ItemDeleteDTO dto){
        nationalityService.delete(nationalityService.get(dto.getId()));
        return "redirect:nationality.list?type=2";
    }
}
