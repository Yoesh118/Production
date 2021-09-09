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
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.CustomerLevelValidator;
import org.production.business.domain.production.CustomerLevel;
import org.production.business.service.production.CustomerLevelService;
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
@RequestMapping("/customerLevel")
public class CustomerLevelController extends BaseController{

    @Resource
    private CustomerLevelService customerLevelService;
    @Resource
    private CustomerLevelValidator customerLevelValidator;

    @RequestMapping(value = "/customerLevel.form", method = RequestMethod.GET)
    public String customerLevelForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Customer Level");
        model.addAttribute("itemDelete", "customerLevel.list");
        CustomerLevel p = new CustomerLevel();
        if (id != null) {
            p = customerLevelService.get(id);
        }
        model.addAttribute("item", p);
        return "product/customerLevelForm";
    }

    @RequestMapping(value = "/customerLevel.form", method = RequestMethod.POST)
    public String saveCustomerLevel(@ModelAttribute("item") @Valid CustomerLevel customerLevel, BindingResult result, ModelMap model) {
        customerLevelValidator.validate(customerLevel, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit CustomerLevel");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", customerLevel);
            model.addAttribute("itemDelete", "customerLevel.list");
            return "product/customerLevelForm";
        }
        customerLevelService.save(customerLevel);
        return "redirect: customerLevel.list?type=1";
    }

    @RequestMapping(value = {"/customerLevel.list", "/"}, method = RequestMethod.GET)
    public String customerLevelList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Customer Level List");
        model.addAttribute("items", customerLevelService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/customerLevelList";
    }
    
    @RequestMapping(value = "customerLevel.delete", method = RequestMethod.GET)
    public String getCustomerLevelDeleteForm(@RequestParam("id") String id, ModelMap model){
        CustomerLevel customerLevel = customerLevelService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, customerLevel.getName(), "customerLevel.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+customerLevel.getName()+" CustomerLevel");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "customerLevel.delete", method = RequestMethod.POST)
    public String deleteCustomerLevel(@Valid ItemDeleteDTO dto){
        customerLevelService.delete(customerLevelService.get(dto.getId()));
        return "redirect:customerLevel.list?type=2";
    }
}
