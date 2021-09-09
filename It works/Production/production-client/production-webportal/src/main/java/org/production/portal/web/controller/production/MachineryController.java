package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.MachineryValidator;
import org.production.business.domain.production.Machinery;
import org.production.business.service.production.MachineryService;
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
@RequestMapping("/machinery")
public class MachineryController extends BaseController{

    @Resource
    private MachineryService machineryService;
    @Resource
    private MachineryValidator machineryValidator;

    @RequestMapping(value = "/machinery.form", method = RequestMethod.GET)
    public String machineryForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Machinery");
        Machinery p = new Machinery();
        if (id != null) {
            p = machineryService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "machinery.list?type=3");
        return "product/machineryForm";
    }

    @RequestMapping(value = "/machinery.form", method = RequestMethod.POST)
    public String saveMachinerys(@ModelAttribute("item") @Valid Machinery machinery, BindingResult result, ModelMap model) {
        machineryValidator.validate(machinery, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Machinery");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", machinery);
            return "product/machineryForm";
        }
        machineryService.save(machinery);
        return "redirect: machinery.list?type=1";
    }

    @RequestMapping(value = {"/machinery.list", "/"}, method = RequestMethod.GET)
    public String machineryList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Machinery List");
        model.addAttribute("items", machineryService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "product/machineryList";
    }

    @RequestMapping(value = "machinery.delete", method = RequestMethod.GET)
    public String getMachinerysDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Machinery machinery = machineryService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, machinery.getDescription(), "machinery.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + machinery.getDescription() + " Machinerys");
        return "admin/deleteItem";
    }

    @RequestMapping(value = "machinery.delete", method = RequestMethod.POST)
    public String deleteMachinerys(@Valid ItemDeleteDTO dto) {
        machineryService.delete(machineryService.get(dto.getId()));
        return "redirect:machinery.list?type=2";
    }
}
