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
import org.production.portal.web.validator.CityValidator;
import org.production.business.domain.City;
import org.production.business.service.CityService;
import org.production.business.util.dto.ItemDeleteDTO;
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
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/admin/city")
public class CityController extends BaseController {

    @Resource
    private CityService cityService;
    @Resource
    private CityValidator cityValidator;

    @RequestMapping(value = "/city.form", method = RequestMethod.GET)
    public String cityForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit City");
        City p = new City();
        if (id != null) {
            p = cityService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "city.list?type=3");
        return "admin/cityForm";
    }

    @RequestMapping(value = "/city.form", method = RequestMethod.POST)
    public String saveCity(@ModelAttribute("item") @Valid City city, BindingResult result, ModelMap model) {
        cityValidator.validate(city, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit City");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", city);
            return "admin/cityForm";
        }
        cityService.save(city);
        return "redirect: city.list?type=1";
    }

    @RequestMapping(value = {"/city.list", "/"}, method = RequestMethod.GET)
    public String cityList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::City List");
        model.addAttribute("items", cityService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "admin/cityList";
    }
    
    @RequestMapping(value = "city.delete", method = RequestMethod.GET)
    public String getCityDeleteForm(@RequestParam("id") String id, ModelMap model){
        City city = cityService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, city.getName(), "city.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+city.getName()+" City");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "city.delete", method = RequestMethod.POST)
    public String deleteCity(@Valid ItemDeleteDTO dto){
        cityService.delete(cityService.get(dto.getId()));
        return "redirect:city.list?type=2";
    }
}