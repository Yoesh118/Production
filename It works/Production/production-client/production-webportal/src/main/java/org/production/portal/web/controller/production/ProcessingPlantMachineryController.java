/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantMachinery;
import org.production.business.service.production.MachineryService;
import org.production.business.service.production.ProcessingPlantMachineryService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessingPlantMachineryValidator;
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
@RequestMapping("/processingPlant/machinery")
public class ProcessingPlantMachineryController extends BaseController {

    @Resource
    private ProcessingPlantMachineryService processingPlantMachineryService;
    @Resource
    private ProcessingPlantMachineryValidator processingPlantMachineryValidator;
    @Resource
    private ProcessingPlantService processingPlantService;
    @Resource
    private MachineryService machineryService;
    @Resource
    ProductionTeamService productionTeamService;

    private String setUpModel(ModelMap model, ProcessingPlantMachinery item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Processing Plant Machinery Details");
        model.addAttribute("item", item);
        model.addAttribute("processingPlant", processingPlantService.get(item.getProcessingPlant().getProcessingPlantId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("machinery", machineryService.getAll());
        model.addAttribute("productionTeam", productionTeamService.getAll());
        return "product/processingPlantMachineryForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String processingPlantId) {
        ProcessingPlantMachinery p;
        if (id != null) {
            p = processingPlantMachineryService.get(id);
            return setUpModel(model, p);
        }
        p = new ProcessingPlantMachinery(processingPlantService.get(processingPlantId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProcessingPlantMachinery processingPlantMachinery, BindingResult result, ModelMap model) {
        processingPlantMachineryValidator.validate(processingPlantMachinery, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processingPlantMachinery);
            return "product/processingPlantMachineryForm";
        }
        processingPlantMachineryService.save(processingPlantMachinery);
        return "redirect:../dashboard/profile.htm?type=1&id=" + processingPlantMachinery.getProcessingPlant().getProcessingPlantId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessingPlantMachinery processingPlantMachinery = processingPlantMachineryService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processingPlantMachinery.getProcessingPlant().getProcessingPlantName()+" Contact item", "../dashboard/profile.htm?type=3&id="+processingPlantMachinery.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + processingPlantMachinery.getProcessingPlant().getProcessingPlantName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProcessingPlantMachinery contact = processingPlantMachineryService.get(dto.getId());
        ProcessingPlant p = contact.getProcessingPlant();
        processingPlantMachineryService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProcessingPlantId();
    }
}