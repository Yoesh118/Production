/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseTools;
import org.production.business.service.production.ProductWarehouseToolsService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.service.production.ToolsService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductWarehouseToolsValidator;
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
@RequestMapping("/productWarehouse/tools")
public class ProductWarehouseToolsController extends BaseController {

    @Resource
    private ProductWarehouseToolsService productWarehouseToolsService;
    @Resource
    private ProductWarehouseToolsValidator productWarehouseToolsValidator;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource 
    private ToolsService toolsService;
    @Resource
    private ProductionTeamService productionTeamService;

    private String setUpModel(ModelMap model, ProductWarehouseTools item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Product Warehouse Tool Details");
        model.addAttribute("item", item);
        model.addAttribute("productWarehouse", productWarehouseService.get(item.getProductWarehouse().getWarehouseId()));
        model.addAttribute("tools", toolsService.getAll());
        model.addAttribute("productionTeam", productionTeamService.getAll());
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProductWarehouse().getWarehouseId());
        return "product/productWarehouseToolsForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String warehouseId) {
        ProductWarehouseTools p;
        if (id != null) {
            p = productWarehouseToolsService.get(id);
            return setUpModel(model, p);
        }
        p = new ProductWarehouseTools(productWarehouseService.get(warehouseId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProductWarehouseTools productWarehouseTools, BindingResult result, ModelMap model) {
        productWarehouseToolsValidator.validate(productWarehouseTools, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productWarehouseTools);
            return "product/productWarehouseToolsForm";
        }
        productWarehouseToolsService.save(productWarehouseTools);
        return "redirect:../dashboard/profile.htm?type=1&id=" + productWarehouseTools.getProductWarehouse().getWarehouseId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductWarehouseTools productWarehouseTools = productWarehouseToolsService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productWarehouseTools.getProductWarehouse().getWarehouseName(),"../dashboard/profile.htm?type=3&id="+productWarehouseTools.getProductWarehouse().getWarehouseId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + productWarehouseTools.getProductWarehouse().getWarehouseName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProductWarehouseTools contact = productWarehouseToolsService.get(dto.getId());
        ProductWarehouse p = contact.getProductWarehouse();
        productWarehouseToolsService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getWarehouseId();
    }
}