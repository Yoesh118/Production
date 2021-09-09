/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehousePos;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.ProductWarehousePosService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductWarehousePosValidator;
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
@RequestMapping("/productWarehouse/pos")
public class ProductWarehousePosController extends BaseController {

    @Resource
    private ProductWarehousePosService productWarehousePosService;
    @Resource
    private ProductWarehousePosValidator productWarehousePosValidator;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private BatchStatusService batchStatusService;

    private String setUpModel(ModelMap model, ProductWarehousePos item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Product Warehouse POS Details");
        model.addAttribute("item", item);
        model.addAttribute("productWarehouse", productWarehouseService.get(item.getProductWarehouse().getWarehouseId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProductWarehouse().getWarehouseId());
        model.addAttribute("batchStatus", batchStatusService.getAll());
        return "product/productWarehousePosForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String warehouseId) {
        ProductWarehousePos p;
        if (id != null) {
            p = productWarehousePosService.get(id);
            return setUpModel(model, p);
        }
        p = new ProductWarehousePos(productWarehouseService.get(warehouseId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProductWarehousePos productWarehousePos, BindingResult result, ModelMap model) {
        productWarehousePosValidator.validate(productWarehousePos, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productWarehousePos);
            return "product/productWarehousePosForm";
        }
        productWarehousePosService.save(productWarehousePos);
        return "redirect:../dashboard/profile.htm?type=1&id=" + productWarehousePos.getProductWarehouse().getWarehouseId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductWarehousePos productWarehousePos = productWarehousePosService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productWarehousePos.getProductWarehouse().getWarehouseName(), "../dashboard/profile.htm?type=3&id="+productWarehousePos.getProductWarehouse().getWarehouseId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + productWarehousePos.getProductWarehouse().getWarehouseName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProductWarehousePos contact = productWarehousePosService.get(dto.getId());
        ProductWarehouse p = contact.getProductWarehouse();
        productWarehousePosService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getWarehouseId();
    }
}