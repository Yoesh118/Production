/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.ProcurementCost;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.ProcurementCostService;
import org.production.business.service.production.ProductionCostService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcurementCostValidator;
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
@RequestMapping("/productionCost/procurementCost")
public class ProcurementCostController extends BaseController {

    @Resource
    private ProcurementCostService procurementCostService;
    @Resource
    private ProcurementCostValidator procurementCostValidator;
    @Resource
    private ProductionCostService productionCostService;
    @Resource
    private BatchStatusService batchStatusService;

    private String setUpModel(ModelMap model, ProcurementCost item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Production Cost Details");
        model.addAttribute("item", item);
        model.addAttribute("batchStatus", batchStatusService.getAll());
        model.addAttribute("productionCost", productionCostService.get(item.getProductionCost().getProductionCostId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProductionCost().getProductionCostId());
        
        return "product/procurementCostForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String productionCostId) {
        ProcurementCost p;
        if (id != null) {
            p = procurementCostService.get(id);
            return setUpModel(model, p);
        }
        p = new ProcurementCost(productionCostService.get(productionCostId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProcurementCost procurementCost, BindingResult result, ModelMap model) {
        procurementCostValidator.validate(procurementCost, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, procurementCost);
            return "product/procurementCostForm";
        }
        procurementCostService.save(procurementCost);
        return "redirect:../dashboard/profile.htm?type=1&id=" + procurementCost.getProductionCost().getProductionCostId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcurementCost procurementCost = procurementCostService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, procurementCost.getProductionCost().getName(), "../dashboard/profile.htm?type=3&id="+procurementCost.getProductionCost().getProductionCostId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + procurementCost.getProductionCost().getName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProcurementCost contact = procurementCostService.get(dto.getId());
        ProductionCost p = contact.getProductionCost();
        procurementCostService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProductionCostId();
    }
}