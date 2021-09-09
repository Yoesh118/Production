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
import org.production.portal.web.validator.SupportingDocumentValidator;
import org.production.business.domain.SupportingDocument;
import org.production.business.service.SupportingDocumentService;
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
@RequestMapping("/admin/supportingDocument")
public class SupportingDocumentController extends BaseController{

    @Resource
    private SupportingDocumentService supportingDocumentService;
    @Resource
    private SupportingDocumentValidator supportingDocumentValidator;
    @Resource
    private ProvinceService provinceService;

    @RequestMapping(value = "/supportingDocument.form", method = RequestMethod.GET)
    public String supportingDocumentForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit SupportingDocument");
        model.addAttribute("itemDelete", "supportingDocument.list");
        model.addAttribute("provinces", provinceService.getAll());
        SupportingDocument p = new SupportingDocument();
        if (id != null) {
            p = supportingDocumentService.get(id);
        }
        model.addAttribute("item", p);
        return "admin/supportingDocumentForm";
    }

    @RequestMapping(value = "/supportingDocument.form", method = RequestMethod.POST)
    public String saveSupportingDocument(@ModelAttribute("item") @Valid SupportingDocument supportingDocument, BindingResult result, ModelMap model) {
        supportingDocumentValidator.validate(supportingDocument, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit SupportingDocument");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", supportingDocument);
            model.addAttribute("itemDelete", "supportingDocument.list");
            return "admin/supportingDocumentForm";
        }
        supportingDocumentService.save(supportingDocument);
        return "redirect: supportingDocument.list?type=1";
    }

    @RequestMapping(value = {"/supportingDocument.list", "/"}, method = RequestMethod.GET)
    public String supportingDocumentList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::SupportingDocument List");
        model.addAttribute("items", supportingDocumentService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "admin/supportingDocumentList";
    }
    
    @RequestMapping(value = "supportingDocument.delete", method = RequestMethod.GET)
    public String getSupportingDocumentDeleteForm(@RequestParam("id") String id, ModelMap model){
        SupportingDocument supportingDocument = supportingDocumentService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, supportingDocument.getName(), "supportingDocument.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+supportingDocument.getName()+" SupportingDocument");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "supportingDocument.delete", method = RequestMethod.POST)
    public String deleteSupportingDocument(@Valid ItemDeleteDTO dto){
        supportingDocumentService.delete(supportingDocumentService.get(dto.getId()));
        return "redirect:supportingDocument.list?type=2";
    }
}
