 package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.CapacityPlanValidator;
import org.production.business.domain.production.CapacityPlan;
import org.production.business.service.production.CapacityPlanService;
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
@RequestMapping("production/capacityPlan")
public class CapacityPlanController extends BaseController{

    @Resource
    private CapacityPlanService capacityPlanService;
    @Resource
    private CapacityPlanValidator capacityPlanValidator;

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String capacityPlanForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Capacity Plan");
        CapacityPlan p = new CapacityPlan();
        if (id != null) {
            p = capacityPlanService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "capacityPlan.list?type=3");
        return "product/capacityPlanNationalForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveCapacityPlan(@ModelAttribute("item") @Valid CapacityPlan capacityPlan, BindingResult result, ModelMap model) {
        capacityPlanValidator.validate(capacityPlan, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit CapacityPlans");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", capacityPlan);
            return "product/capacityPlanNationalForm";
        }
        capacityPlanService.save(capacityPlan);
        return "redirect: capacityPlan.list?type=1";
    }

    @RequestMapping(value = {"/capacityPlan.list", "/"}, method = RequestMethod.GET)
    public String capacityPlanList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Capacity Plan List");
        model.addAttribute("items", capacityPlanService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/capacityPlanList";
    }

    @RequestMapping(value = "capacityPlan.delete", method = RequestMethod.GET)
    public String getCapacityPlansDeleteForm(@RequestParam("id") String id, ModelMap model) {
        CapacityPlan capacityPlan = capacityPlanService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, capacityPlan.getCapacityPlanDescription(), "capacityPlan.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + capacityPlan.getCapacityPlanDescription() + " CapacityPlans");
        return "product/deleteItem";
    }

    @RequestMapping(value = "capacityPlan.delete", method = RequestMethod.POST)
    public String deleteCapacityPlan(@Valid ItemDeleteDTO dto) {
        capacityPlanService.delete(capacityPlanService.get(dto.getId()));
        return "redirect:capacityPlan.list?type=2";
    }
}
