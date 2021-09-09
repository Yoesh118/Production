/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantMaterial;
import org.production.business.service.production.MaterialService;
import org.production.business.service.production.ProcessingPlantMaterialService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessingPlantMaterialValidator;
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
@RequestMapping("/processingPlant/material")
public class ProcessingPlantMaterialController extends BaseController {

    @Resource
    private ProcessingPlantMaterialService processingPlantMaterialService;
    @Resource
    private ProcessingPlantMaterialValidator processingPlantMaterialValidator;
    @Resource
    private ProcessingPlantService processingPlantService;
    @Resource
    private MaterialService materialService;

    private String setUpModel(ModelMap model, ProcessingPlantMaterial item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Processing Plant Material Details");
        model.addAttribute("item", item);
        model.addAttribute("processingPlant", processingPlantService.get(item.getProcessingPlant().getProcessingPlantId()));
        model.addAttribute("material", materialService.getAll());
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProcessingPlant().getProcessingPlantId());
        return "product/processingPlantMaterialForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String processingPlantId) {
        ProcessingPlantMaterial p;
        if (id != null) {
            p = processingPlantMaterialService.get(id);
            return setUpModel(model, p);
        }
        p = new ProcessingPlantMaterial(processingPlantService.get(processingPlantId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProcessingPlantMaterial processingPlantMaterial, BindingResult result, ModelMap model) {
        processingPlantMaterialValidator.validate(processingPlantMaterial, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processingPlantMaterial);
            return "product/processingPlantMaterialForm";
        }
        processingPlantMaterialService.save(processingPlantMaterial);
        return "redirect:../dashboard/profile.htm?type=1&id=" + processingPlantMaterial.getProcessingPlant().getProcessingPlantId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessingPlantMaterial processingPlantMaterial = processingPlantMaterialService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processingPlantMaterial.getProcessingPlant().getProcessingPlantName(), "../dashboard/profile.htm?type=3&id="+processingPlantMaterial.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + processingPlantMaterial.getProcessingPlant().getProcessingPlantName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProcessingPlantMaterial contact = processingPlantMaterialService.get(dto.getId());
        ProcessingPlant p = contact.getProcessingPlant();
        processingPlantMaterialService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProcessingPlantId();
    }
}