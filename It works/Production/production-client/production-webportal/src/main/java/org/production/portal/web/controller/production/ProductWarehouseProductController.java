/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.domain.production.ProductWarehouseProduct;
import org.production.business.service.production.ProductService;
import org.production.business.service.production.ProductWarehouseProductService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductWarehouseProductValidator;
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
@RequestMapping("/productWarehouse/product")
public class ProductWarehouseProductController extends BaseController {

    @Resource
    private ProductWarehouseProductService productWarehouseProductService;
    @Resource
    private ProductWarehouseProductValidator productWarehouseProductValidator;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private ProductService productService;

    private String setUpModel(ModelMap model, ProductWarehouseProduct item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Product Warehouse Product Details");
        model.addAttribute("item", item);
        model.addAttribute("productWarehouse", productWarehouseService.get(item.getProductWarehouse().getWarehouseId()));
        model.addAttribute("itemDelete", "../dashboard/profile.htm?type=3&id="+ item.getProductWarehouse().getWarehouseId());
        model.addAttribute("product", productService.getAll());
        return "product/productWarehouseProductForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String getItemForm(ModelMap model, @RequestParam(required = false) String id, @RequestParam(required = false) String warehouseId) {
        ProductWarehouseProduct p;
        if (id != null) {
            p = productWarehouseProductService.get(id);
            return setUpModel(model, p);
        }
        p = new ProductWarehouseProduct(productWarehouseService.get(warehouseId));
        return setUpModel(model, p);
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") @Valid ProductWarehouseProduct productWarehouseProduct, BindingResult result, ModelMap model) {
        productWarehouseProductValidator.validate(productWarehouseProduct, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productWarehouseProduct);
            return "product/productWarehouseProductForm";
        }
        productWarehouseProductService.save(productWarehouseProduct);
        return "redirect:../dashboard/profile.htm?type=1&id=" + productWarehouseProduct.getProductWarehouse().getWarehouseId();
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.GET)
    public String getDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductWarehouseProduct productWarehouseProduct = productWarehouseProductService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productWarehouseProduct.getProductWarehouse().getWarehouseName(), "../dashboard/profile.htm?type=3&id="+productWarehouseProduct.getProductWarehouse().getWarehouseId());
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix+"Delete " + productWarehouseProduct.getProductWarehouse().getWarehouseName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "item.delete", method = RequestMethod.POST)
    public String deleteItem(@Valid ItemDeleteDTO dto) {
        ProductWarehouseProduct contact = productWarehouseProductService.get(dto.getId());
        ProductWarehouse p = contact.getProductWarehouse();
        productWarehouseProductService.delete(contact);
        return "redirect:../dashboard/profile.htm?type=2&id=" + p.getWarehouseId();
    }
}