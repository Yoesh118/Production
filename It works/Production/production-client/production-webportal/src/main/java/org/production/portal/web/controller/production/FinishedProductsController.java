package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.FinishedProductsValidator;
import org.production.business.domain.production.FinishedProducts;
import org.production.business.service.production.FinishedProductsService;
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
@RequestMapping("/finishedProducts")
public class FinishedProductsController extends BaseController{

    @Resource
    private FinishedProductsService finishedProductsService;
    @Resource
    private FinishedProductsValidator finishedProductsValidator;
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/finishedProducts.form", method = RequestMethod.GET)
    public String finishedProductsForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Finished Products");
        FinishedProducts p = new FinishedProducts();
        if (id != null) {
            p = finishedProductsService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "finishedProducts.list?type=3");
        model.addAttribute("product", productService.getAll());
        return "product/finishedProductsForm";
    }

    @RequestMapping(value = "/finishedProducts.form", method = RequestMethod.POST)
    public String saveFinishedProductss(@ModelAttribute("item") @Valid FinishedProducts finishedProducts, BindingResult result, ModelMap model) {
        finishedProductsValidator.validate(finishedProducts, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Finished Products");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", finishedProducts);
            return "product/finishedProductsForm";
        }
        finishedProductsService.save(finishedProducts);
        return "redirect: finishedProducts.list?type=1";
    }

    @RequestMapping(value = {"/finishedProducts.list", "/"}, method = RequestMethod.GET)
    public String finishedProductsList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Finished Products List");
        model.addAttribute("items", finishedProductsService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "product/finishedProductsList";
    }

    @RequestMapping(value = "finishedProducts.delete", method = RequestMethod.GET)
    public String getFinishedProductssDeleteForm(@RequestParam("id") String id, ModelMap model) {
        FinishedProducts finishedProducts = finishedProductsService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, finishedProducts.getFinishedProductsId(), "finishedProducts.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + finishedProducts.getFinishedProductsId() + " Finished Products");
        return "admin/deleteItem";
    }

    @RequestMapping(value = "finishedProducts.delete", method = RequestMethod.POST)
    public String deleteFinishedProductss(@Valid ItemDeleteDTO dto) {
        finishedProductsService.delete(finishedProductsService.get(dto.getId()));
        return "redirect:finishedProducts.list?type=2";
    }
}
