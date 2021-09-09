package org.production.portal.web.controller.production;

import org.production.portal.web.controller.admin.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ToolsValidator;
import org.production.business.domain.production.Tools;
import org.production.business.service.production.ToolsService;
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
@RequestMapping("/tools")
public class ToolsController extends BaseController{

    @Resource
    private ToolsService toolsService;
    @Resource
    private ToolsValidator toolsValidator;

    @RequestMapping(value = "/tools.form", method = RequestMethod.GET)
    public String toolsForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Tools");
        Tools p = new Tools();
        if (id != null) {
            p = toolsService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "tools.list");
        return "product/toolsForm";
    }

    @RequestMapping(value = "/tools.form", method = RequestMethod.POST)
    public String saveToolss(@ModelAttribute("item") @Valid Tools tools, BindingResult result, ModelMap model) {
        toolsValidator.validate(tools, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Tools");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", tools);
            return "product/toolsForm";
        }
        toolsService.save(tools);
        return "redirect: tools.list?type=1";
    }

    @RequestMapping(value = {"/tools.list", "/"}, method = RequestMethod.GET)
    public String toolsList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Tools List");
        model.addAttribute("items", toolsService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "product/toolsList";
    }

    @RequestMapping(value = "tools.delete", method = RequestMethod.GET)
    public String getToolssDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Tools tools = toolsService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, tools.getDescription(), "tools.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + tools.getDescription());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "tools.delete", method = RequestMethod.POST)
    public String deleteToolss(@Valid ItemDeleteDTO dto) {
        toolsService.delete(toolsService.get(dto.getId()));
        return "redirect:tools.list?type=2";
    }
}
