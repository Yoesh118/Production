/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseMachinery;
import org.production.business.service.production.MachineryService;
import org.production.business.service.production.ProductWarehouseMachineryService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductWarehouseMachineryValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Rachel Makwara
 */
@Controller
@RequestMapping("/productWarehouse/machinery")
public class ProductWarehouseMachineryController extends BaseController {

    @Resource
    private ProductWarehouseMachineryService productWarehouseMachineryService;
    @Resource
    private ProductWarehouseMachineryValidator productWarehouseMachineryValidator;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private MachineryService machineryService;
    @Resource
    private ProductionTeamService productionTeamService;

    private String setUpModel(ModelMap model, ProductWarehouseMachinery item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Product Warehouse Machinery Details");
        model.addAttribute("item", item);
        model.addAttribute("productWarehouse", productWarehouseService.get(item.getProductWarehouse().getWarehouseId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id=" + item.getProductWarehouse().getWarehouseId());
        model.addAttribute("machinery", machineryService.getAll());
        model.addAttribute("productionTeam", productionTeamService.getAll());
        return "product/productWarehouseMachineryForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String warehouseId) {
        ProductWarehouseMachinery p;
        if (id != null) {
            p = productWarehouseMachineryService.get(id);
            return setUpModel(model, p);
        }
        p = new ProductWarehouseMachinery(productWarehouseService.get(warehouseId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProductWarehouseMachinery productWarehouseMachinery, BindingResult result, ModelMap model) {
        productWarehouseMachineryValidator.validate(productWarehouseMachinery, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productWarehouseMachinery);
            return "product/productWarehouseMachineryForm";
        }
        productWarehouseMachineryService.save(productWarehouseMachinery);
        return "redirect:../dashboard/profile.htm?type=1&id=" + productWarehouseMachinery.getProductWarehouse().getWarehouseId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductWarehouseMachinery productWarehouseMachinery = productWarehouseMachineryService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productWarehouseMachinery.getProductWarehouse().getWarehouseName(), "../dashboard/profile.htm?type=3&id=" + productWarehouseMachinery.getProductWarehouse().getWarehouseId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + productWarehouseMachinery.getProductWarehouse().getWarehouseName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProductWarehouseMachinery contact = productWarehouseMachineryService.get(dto.getId());
        ProductWarehouse p = contact.getProductWarehouse();
        productWarehouseMachineryService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getWarehouseId();
    }
}
