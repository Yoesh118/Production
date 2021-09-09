/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseProductionTeam;
import org.production.business.service.production.ProductWarehouseProductionTeamService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductWarehouseProductionTeamValidator;
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
@RequestMapping("/productWarehouse/productionTeam")
public class ProductWarehouseProductionTeamController extends BaseController {

    @Resource
    private ProductWarehouseProductionTeamService productWarehouseProductionTeamService;
    @Resource
    private ProductWarehouseProductionTeamValidator productWarehouseProductionTeamValidator;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private ProductionTeamService productionTeamService;

    private String setUpModel(ModelMap model, ProductWarehouseProductionTeam item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Product Warehouse Production Team Details");
        model.addAttribute("item", item);
        model.addAttribute("productWarehouse", productWarehouseService.get(item.getProductWarehouse().getWarehouseId()));
        model.addAttribute("productionTeam", productionTeamService.getAll());
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProductWarehouse().getWarehouseId());
        return "product/productWarehouseProductionTeamForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String warehouseId) {
        ProductWarehouseProductionTeam p;
        if (id != null) {
            p = productWarehouseProductionTeamService.get(id);
            return setUpModel(model, p);
        }
        p = new ProductWarehouseProductionTeam(productWarehouseService.get(warehouseId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProductWarehouseProductionTeam productWarehouseProductionTeam, BindingResult result, ModelMap model) {
        productWarehouseProductionTeamValidator.validate(productWarehouseProductionTeam, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productWarehouseProductionTeam);
            return "product/productWarehouseProductionTeamForm";
        }
        productWarehouseProductionTeamService.save(productWarehouseProductionTeam);
        return "redirect:../dashboard/profile.htm?type=1&id=" + productWarehouseProductionTeam.getProductWarehouse().getWarehouseId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductWarehouseProductionTeam productWarehouseProductionTeam = productWarehouseProductionTeamService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productWarehouseProductionTeam.getProductWarehouse().getWarehouseName(), "../dashboard/profile.htm?type=3&id="+productWarehouseProductionTeam.getProductWarehouse().getWarehouseId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + productWarehouseProductionTeam.getProductWarehouse().getWarehouseName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProductWarehouseProductionTeam contact = productWarehouseProductionTeamService.get(dto.getId());
        ProductWarehouse p = contact.getProductWarehouse();
        productWarehouseProductionTeamService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getWarehouseId();
    }
}