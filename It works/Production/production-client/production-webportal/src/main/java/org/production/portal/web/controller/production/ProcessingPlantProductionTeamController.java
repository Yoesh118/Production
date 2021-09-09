/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.domain.production.ProcessingPlantProductionTeam;
import org.production.business.service.production.ProcessingPlantProductionTeamService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessingPlantProductionTeamValidator;
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
@RequestMapping("/processingPlant/productionTeam")
public class ProcessingPlantProductionTeamController extends BaseController {

    @Resource
    private ProcessingPlantProductionTeamService processingPlantProductionTeamService;
    @Resource
    private ProcessingPlantProductionTeamValidator processingPlantProductionTeamValidator;
    @Resource
    private ProcessingPlantService processingPlantService;
    @Resource
    private ProductionTeamService productionTeamService;

    private String setUpModel(ModelMap model, ProcessingPlantProductionTeam item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Processing Plant Production Team Details");
        model.addAttribute("item", item);
        model.addAttribute("processingPlant", processingPlantService.get(item.getProcessingPlant().getProcessingPlantId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("productionTeam", productionTeamService.getAll());
        return "product/processingPlantProductionTeamForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String processingPlantId) {
        ProcessingPlantProductionTeam p;
        if (id != null) {
            p = processingPlantProductionTeamService.get(id);
            return setUpModel(model, p);
        }
        p = new ProcessingPlantProductionTeam(processingPlantService.get(processingPlantId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProcessingPlantProductionTeam processingPlantProductionTeam, BindingResult result, ModelMap model) {
        processingPlantProductionTeamValidator.validate(processingPlantProductionTeam, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processingPlantProductionTeam);
            return "product/processingPlantProductionTeamForm";
        }
        processingPlantProductionTeamService.save(processingPlantProductionTeam);
        return "redirect:../dashboard/profile.htm?type=1&id=" + processingPlantProductionTeam.getProcessingPlant().getProcessingPlantId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessingPlantProductionTeam processingPlantProductionTeam = processingPlantProductionTeamService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processingPlantProductionTeam.getProcessingPlant().getProcessingPlantName(), "../dashboard/profile.htm?type=3&id="+processingPlantProductionTeam.getProcessingPlant().getProcessingPlantId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + processingPlantProductionTeam.getProcessingPlant().getProcessingPlantName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProcessingPlantProductionTeam contact = processingPlantProductionTeamService.get(dto.getId());
        ProcessingPlant p = contact.getProcessingPlant();
        processingPlantProductionTeamService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProcessingPlantId();
    }
}