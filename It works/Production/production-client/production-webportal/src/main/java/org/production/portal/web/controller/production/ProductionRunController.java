package org.production.portal.web.controller.production;

import org.production.portal.web.controller.admin.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductionRunValidator;
import org.production.business.domain.production.ProductionRun;
import org.production.business.service.production.ProductionRunService;
import org.production.business.util.dto.ItemDeleteDTO;
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
@RequestMapping("/admin/productionRun")
public class ProductionRunController extends BaseController{

    @Resource
    private ProductionRunService productionRunService;
    @Resource
    private ProductionRunValidator productionRunValidator;

    @RequestMapping(value = "/productionRun.form", method = RequestMethod.GET)
    public String productionRunForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Production Run");
        ProductionRun p = new ProductionRun();
        if (id != null) {
            p = productionRunService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "productionRun.list");
        return "admin/productionRunForm";
    }

    @RequestMapping(value = "/productionRun.form", method = RequestMethod.POST)
    public String saveProductionRuns(@ModelAttribute("item") @Valid ProductionRun productionRun, BindingResult result, ModelMap model) {
        productionRunValidator.validate(productionRun, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Production Run");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", productionRun);
            return "admin/productionRunForm";
        }
        productionRunService.save(productionRun);
        return "redirect: productionRun.list?type=1";
    }

    @RequestMapping(value = {"/productionRun.list", "/"}, method = RequestMethod.GET)
    public String productionRunList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Production Run List");
        model.addAttribute("items", productionRunService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "admin/productionRunList";
    }

    @RequestMapping(value = "productionRun.delete", method = RequestMethod.GET)
    public String getProductionRunsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductionRun productionRun = productionRunService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productionRun.getProductionRunDescription(), "productionRun.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + productionRun.getProductionRunDescription());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "productionRun.delete", method = RequestMethod.POST)
    public String deleteProductionRuns(@Valid ItemDeleteDTO dto) {
        productionRunService.delete(productionRunService.get(dto.getId()));
        return "redirect:productionRun.list?type=2";
    }
}
