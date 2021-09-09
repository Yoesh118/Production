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
import org.production.portal.web.validator.production.BatchStatusValidator;
import org.production.business.domain.production.BatchStatus;
import org.production.business.service.production.BatchStatusService;
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
@RequestMapping("/batchStatus")
public class BatchStatusController extends BaseController{

    @Resource
    private BatchStatusService batchStatusService;
    @Resource
    private BatchStatusValidator batchStatusValidator;

    @RequestMapping(value = "/batchStatus.form", method = RequestMethod.GET)
    public String batchStatusForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Batch Status");
        model.addAttribute("itemDelete", "batchStatus.list");
        BatchStatus p = new BatchStatus();
        if (id != null) {
            p = batchStatusService.get(id);
        }
        model.addAttribute("item", p);
        return "product/batchStatusForm";
    }

    @RequestMapping(value = "/batchStatus.form", method = RequestMethod.POST)
    public String saveBatchStatus(@ModelAttribute("item") @Valid BatchStatus batchStatus, BindingResult result, ModelMap model) {
        batchStatusValidator.validate(batchStatus, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit BatchStatus");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", batchStatus);
            model.addAttribute("itemDelete", "batchStatus.list");
            return "product/batchStatusForm";
        }
        batchStatusService.save(batchStatus);
        return "redirect: batchStatus.list?type=1";
    }

    @RequestMapping(value = {"/batchStatus.list", "/"}, method = RequestMethod.GET)
    public String batchStatusList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Batch Status List");
        model.addAttribute("items", batchStatusService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/batchStatusList";
    }
    
    @RequestMapping(value = "batchStatus.delete", method = RequestMethod.GET)
    public String getBatchStatusDeleteForm(@RequestParam("id") String id, ModelMap model){
        BatchStatus batchStatus = batchStatusService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, batchStatus.getName(), "batchStatus.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+batchStatus.getName()+" BatchStatus");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "batchStatus.delete", method = RequestMethod.POST)
    public String deleteBatchStatus(@Valid ItemDeleteDTO dto){
        batchStatusService.delete(batchStatusService.get(dto.getId()));
        return "redirect:batchStatus.list?type=2";
    }
}
