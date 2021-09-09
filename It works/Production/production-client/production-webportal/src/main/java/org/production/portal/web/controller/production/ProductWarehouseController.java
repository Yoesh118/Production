package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductWarehouseValidator;
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
@RequestMapping("/productWarehouse")
public class ProductWarehouseController extends BaseController {

    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private ProductWarehouseValidator productWarehouseValidator;


    public void setUpModel(ModelMap model, ProductWarehouse item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit ProductWarehouse");
        model.addAttribute("productWarehouse", item);
        model.addAttribute("itemDelete", "productWarehouse.list");
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        ProductWarehouse p;
        if (id != null) {
            p = productWarehouseService.get(id);
        } else {
            p = new ProductWarehouse();
        }

        setUpModel(model, p);
        return "product/productWarehouseForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveProductWarehouses(@ModelAttribute("productWarehouse") @Valid ProductWarehouse productWarehouse, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        productWarehouseValidator.validate(productWarehouse, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productWarehouse);
            return "product/productWarehouseForm";
        }
        ProductWarehouse comp = productWarehouseService.save(productWarehouse);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getWarehouseId();
    }

    @RequestMapping(value = {"/productWarehouse.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Product Warehouse List");
        model.addAttribute("items", productWarehouseService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/productWarehouseList";
    }

    @RequestMapping(value = "productWarehouse.delete", method = RequestMethod.GET)
    public String getProductWarehousesDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductWarehouse productWarehouse = productWarehouseService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productWarehouse.getWarehouseName(), "productWarehouse.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + productWarehouse.getWarehouseName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "productWarehouse.delete", method = RequestMethod.POST)
    public String deleteProductWarehouses(@Valid ItemDeleteDTO dto) {
        productWarehouseService.delete(productWarehouseService.get(dto.getId()));
        return "redirect:productWarehouse.list?type=2";
    }
}
