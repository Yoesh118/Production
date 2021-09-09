/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductionCost;
import org.production.business.domain.production.Other;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.OtherService;
import org.production.business.service.production.ProductionCostService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.OtherValidator;
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
@RequestMapping("/productionCost/other")
public class OtherController extends BaseController {

    @Resource
    private OtherService otherService;
    @Resource
    private OtherValidator otherValidator;
    @Resource
    private ProductionCostService productionCostService;
    @Resource
    private BatchStatusService batchStatusService;


    private String setUpModel(ModelMap model, Other item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Production Cost Details");
        model.addAttribute("item", item);
        model.addAttribute("batchStatus", batchStatusService.getAll());
        model.addAttribute("productionCost", productionCostService.get(item.getProductionCost().getProductionCostId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProductionCost().getProductionCostId());
        return "product/otherForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String productionCostId) {
        Other p;
        if (id != null) {
            p = otherService.get(id);
            return setUpModel(model, p);
        }
        p = new Other(productionCostService.get(productionCostId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid Other other, BindingResult result, ModelMap model) {
        otherValidator.validate(other, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, other);
            return "product/otherForm";
        }
        otherService.save(other);
        return "redirect:../dashboard/profile.htm?type=1&id=" + other.getProductionCost().getProductionCostId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Other other = otherService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, other.getProductionCost().getName(), "../dashboard/profile.htm?type=3&id="+other.getProductionCost().getProductionCostId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + other.getProductionCost().getName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        Other contact = otherService.get(dto.getId());
        ProductionCost p = contact.getProductionCost();
        otherService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getProductionCostId();
    }
}