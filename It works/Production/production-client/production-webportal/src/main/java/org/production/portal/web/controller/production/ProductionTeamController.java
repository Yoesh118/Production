package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductionTeam;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductionTeamValidator;
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
@RequestMapping("/productionTeam")
public class ProductionTeamController extends BaseController {

    @Resource
    private ProductionTeamService productionTeamService;
    @Resource
    private ProductionTeamValidator productionTeamValidator;


    public void setUpModel(ModelMap model, ProductionTeam item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Production Team");
        model.addAttribute("productionTeam", item);
        model.addAttribute("itemDelete", "productionTeam.list");
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        ProductionTeam p;
        if (id != null) {
            p = productionTeamService.get(id);
        } else {
            p = new ProductionTeam();
        }

        setUpModel(model, p);
        return "product/productionTeamForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveProductionTeams(@ModelAttribute("productionTeam") @Valid ProductionTeam productionTeam, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        productionTeamValidator.validate(productionTeam, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productionTeam);
            return "product/productionTeamForm";
        }
        ProductionTeam comp = productionTeamService.save(productionTeam);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getProductionTeamId();
    }

    @RequestMapping(value = {"/productionTeam.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Production Team List");
        model.addAttribute("items", productionTeamService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/productionTeamList";
    }

    @RequestMapping(value = "productionTeam.delete", method = RequestMethod.GET)
    public String getProductionTeamsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductionTeam productionTeam = productionTeamService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productionTeam.getProductionTeamId(), "productionTeam.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + productionTeam.getProductionTeamId());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "productionTeam.delete", method = RequestMethod.POST)
    public String deleteProductionTeams(@Valid ItemDeleteDTO dto) {
        productionTeamService.delete(productionTeamService.get(dto.getId()));
        return "redirect:productionTeam.list?type=2";
    }
}
