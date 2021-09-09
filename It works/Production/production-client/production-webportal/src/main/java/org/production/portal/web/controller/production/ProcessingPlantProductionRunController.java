/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantProductionRun;
import org.production.business.service.production.ProcessingPlantProductionRunService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessingPlantProductionRunValidator;
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
@RequestMapping("/processingPlant/productionRun")
public class ProcessingPlantProductionRunController extends BaseController {

    @Resource
    private ProcessingPlantProductionRunService processingPlantProductionRunService;
    @Resource
    private ProcessingPlantProductionRunValidator processingPlantProductionRunValidator;
    @Resource
    private ProcessingPlantService processingPlantService;

    private String setUpModel(ModelMap model, ProcessingPlantProductionRun item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Processing Plant Production Run Details");
        model.addAttribute("item", item);
        model.addAttribute("processingPlant", processingPlantService.get(item.getProcessingPlant().getProcessingPlantId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProcessingPlant().getProcessingPlantId());
        return "product/processingPlantProductionRunForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String processingPlantId) {
        ProcessingPlantProductionRun p;
        if (id != null) {
            p = processingPlantProductionRunService.get(id);
            return setUpModel(model, p);
        }
        p = new ProcessingPlantProductionRun(processingPlantService.get(processingPlantId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProcessingPlantProductionRun processingPlantProductionRun, BindingResult result, ModelMap model) {
        processingPlantProductionRunValidator.validate(processingPlantProductionRun, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processingPlantProductionRun);
            return "product/processingPlantProductionRunForm";
        }
        processingPlantProductionRunService.save(processingPlantProductionRun);
        return "redirect:../dashboard/profile.htm?type=1&id=" + processingPlantProductionRun.getProcessingPlant().getProcessingPlantId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessingPlantProductionRun processingPlantProductionRun = processingPlantProductionRunService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processingPlantProductionRun.getProcessingPlant().getProcessingPlantName(), "../dashboard/profile.htm?type=3&id="+processingPlantProductionRun.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + processingPlantProductionRun.getProcessingPlant().getProcessingPlantName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProcessingPlantProductionRun contact = processingPlantProductionRunService.get(dto.getId());
        ProcessingPlant p = contact.getProcessingPlant();
        processingPlantProductionRunService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProcessingPlantId();
    }
}