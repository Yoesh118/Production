package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductionCost;
import org.production.business.service.production.ProductionCostService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductionCostValidator;
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
@RequestMapping("/productionCost")
public class ProductionCostController extends BaseController {

    @Resource
    private ProductionCostService productionCostService;
    @Resource
    private ProductionCostValidator productionCostValidator;


    public void setUpModel(ModelMap model, ProductionCost item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Production Cost");
        model.addAttribute("productionCost", item);
        model.addAttribute("itemDelete", "../index.htm?type=3");
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        ProductionCost p;
        if (id != null) {
            p = productionCostService.get(id);
        } else {
            p = new ProductionCost();
        }

        setUpModel(model, p);
        return "product/productionCostForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveProductionCosts(@ModelAttribute("productionCost") @Valid ProductionCost productionCost, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        productionCostValidator.validate(productionCost, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productionCost);
            return "product/productionCostForm";
        }
        ProductionCost comp = productionCostService.save(productionCost);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getProductionCostId();
    }

    @RequestMapping(value = {"/productionCost.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Production Cost List");
        model.addAttribute("items", productionCostService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/productionCostList";
    }

    @RequestMapping(value = "productionCost.delete", method = RequestMethod.GET)
    public String getProductionCostsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductionCost productionCost = productionCostService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productionCost.getProductionCostId(), "productionCost.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + productionCost.getProductionCostId());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "productionCost.delete", method = RequestMethod.POST)
    public String deleteProductionCosts(@Valid ItemDeleteDTO dto) {
        productionCostService.delete(productionCostService.get(dto.getId()));
        return "redirect:productionCost.list?type=2";
    }
}
