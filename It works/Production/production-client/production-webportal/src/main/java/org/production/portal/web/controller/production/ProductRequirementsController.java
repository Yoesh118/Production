package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductRequirementsValidator;
import org.production.business.domain.production.ProductRequirements;
import org.production.business.service.production.ProductRequirementsService;
import org.production.business.service.production.ProductService;
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
@RequestMapping("/productRequirements")
public class ProductRequirementsController extends BaseController{

    @Resource
    private ProductRequirementsService productRequirementsService;
    @Resource
    private ProductRequirementsValidator productRequirementsValidator;
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/productRequirements.form", method = RequestMethod.GET)
    public String productRequirementsForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production:Create/ Edit Product Requirements");
        ProductRequirements p = new ProductRequirements();
        if (id != null) {
            p = productRequirementsService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "productRequirements.list");
        model.addAttribute("product", productService.getAll());
        return "product/productRequirementsForm";
    }

    @RequestMapping(value = "/productRequirements.form", method = RequestMethod.POST)
    public String saveProductRequirementss(@ModelAttribute("item") @Valid ProductRequirements productRequirements, BindingResult result, ModelMap model) {
        productRequirementsValidator.validate(productRequirements, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production:Create/ Edit Product Requirements");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", productRequirements);
            return "product/productRequirementsForm";
        }
        productRequirementsService.save(productRequirements);
        return "redirect: productRequirements.list?type=1";
    }

    @RequestMapping(value = {"/productRequirements.list", "/"}, method = RequestMethod.GET)
    public String productRequirementsList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production:Product Requirements List");
        model.addAttribute("items", productRequirementsService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "product/productRequirementsList";
    }

    @RequestMapping(value = "productRequirements.delete", method = RequestMethod.GET)
    public String getProductRequirementssDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductRequirements productRequirements = productRequirementsService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productRequirements.getProductRequirementsId(), "productRequirements.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production:Delete " + productRequirements.getProductRequirementsId());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "productRequirements.delete", method = RequestMethod.POST)
    public String deleteProductRequirementss(@Valid ItemDeleteDTO dto) {
        productRequirementsService.delete(productRequirementsService.get(dto.getId()));
        return "redirect:productRequirements.list?type=2";
    }
}
