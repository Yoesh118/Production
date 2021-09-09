/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantTools;
import org.production.business.service.production.ProcessingPlantToolsService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.service.production.ToolsService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessingPlantToolsValidator;
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
@RequestMapping("/processingPlant/tools")
public class ProcessingPlantToolsController extends BaseController {

    @Resource
    private ProcessingPlantToolsService processingPlantToolsService;
    @Resource
    private ProcessingPlantToolsValidator processingPlantToolsValidator;
    @Resource
    private ProcessingPlantService processingPlantService;
    @Resource
    private ToolsService toolsService;
     @Resource
    private ProductionTeamService productionTeamService;

    private String setUpModel(ModelMap model, ProcessingPlantTools item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Processing Plant Tool Details");
        model.addAttribute("item", item);
        model.addAttribute("processingPlant", processingPlantService.get(item.getProcessingPlant().getProcessingPlantId()));
         model.addAttribute("tools", toolsService.getAll());
        model.addAttribute("productionTeam", productionTeamService.getAll());
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProcessingPlant().getProcessingPlantId());
        return "product/processingPlantToolsForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String processingPlantId) {
        ProcessingPlantTools p;
        if (id != null) {
            p = processingPlantToolsService.get(id);
            return setUpModel(model, p);
        }
        p = new ProcessingPlantTools(processingPlantService.get(processingPlantId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProcessingPlantTools processingPlantTools, BindingResult result, ModelMap model) {
        processingPlantToolsValidator.validate(processingPlantTools, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processingPlantTools);
            return "product/processingPlantToolsForm";
        }
        processingPlantToolsService.save(processingPlantTools);
        return "redirect:../dashboard/profile.htm?type=1&id=" + processingPlantTools.getProcessingPlant().getProcessingPlantId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessingPlantTools processingPlantTools = processingPlantToolsService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processingPlantTools.getProcessingPlant().getProcessingPlantName(), "../dashboard/profile.htm?type=3&id="+processingPlantTools.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + processingPlantTools.getProcessingPlant().getProcessingPlantName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProcessingPlantTools contact = processingPlantToolsService.get(dto.getId());
        ProcessingPlant p = contact.getProcessingPlant();
        processingPlantToolsService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProcessingPlantId();
    }
}