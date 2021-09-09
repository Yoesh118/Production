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
import org.production.portal.web.validator.production.CustomersValidator;
import org.production.business.domain.production.Customers;
import org.production.business.service.production.CustomerLevelService;
import org.production.business.service.production.CustomersService;
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
@RequestMapping("/customers")
public class CustomersController extends BaseController{

    @Resource
    private CustomersService customersService;
    @Resource
    private CustomersValidator customersValidator;
    @Resource
    private CustomerLevelService customerLevelService;

    @RequestMapping(value = "/customers.form", method = RequestMethod.GET)
    public String customersForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Customers ");
        model.addAttribute("customerLevel", customerLevelService.getAll());
        model.addAttribute("itemDelete", "customers.list");
        Customers p = new Customers();
        if (id != null) {
            p = customersService.get(id);
        }
        model.addAttribute("item", p);
        return "product/customersForm";
    }

    @RequestMapping(value = "/customers.form", method = RequestMethod.POST)
    public String saveCustomers(@ModelAttribute("item") @Valid Customers customers, BindingResult result, ModelMap model) {
        customersValidator.validate(customers, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Customers");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", customers);
            model.addAttribute("itemDelete", "customers.list");
            return "product/customersForm";
        }
        customersService.save(customers);
        return "redirect: customers.list?type=1";
    }

    @RequestMapping(value = {"/customers.list", "/"}, method = RequestMethod.GET)
    public String customersList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Customers  List");
        model.addAttribute("items", customersService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/customersList";
    }
    
    @RequestMapping(value = "customers.delete", method = RequestMethod.GET)
    public String getCustomersDeleteForm(@RequestParam("id") String id, ModelMap model){
        Customers customers = customersService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, customers.getName(), "customers.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+customers.getName()+" Customers");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "customers.delete", method = RequestMethod.POST)
    public String deleteCustomers(@Valid ItemDeleteDTO dto){
        customersService.delete(customersService.get(dto.getId()));
        return "redirect:customers.list?type=2";
    }
}
