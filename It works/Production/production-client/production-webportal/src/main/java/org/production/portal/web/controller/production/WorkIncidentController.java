package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.WorkIncidentValidator;
import org.production.business.domain.production.WorkIncident;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.WorkIncidentService;
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
@RequestMapping("/workIncident")
public class WorkIncidentController extends BaseController{

    @Resource
    private WorkIncidentService workIncidentService;
    @Resource
    private WorkIncidentValidator workIncidentValidator;
    @Resource
    private BatchStatusService batchStatusService;

    @RequestMapping(value = "/workIncident.form", method = RequestMethod.GET)
    public String workIncidentForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Work Incident");
        WorkIncident p = new WorkIncident();
        if (id != null) {
            p = workIncidentService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "workIncident.list");
        model.addAttribute("batchStatus", batchStatusService.getAll());
        return "product/workIncidentForm";
    }

    @RequestMapping(value = "/workIncident.form", method = RequestMethod.POST)
    public String saveWorkIncidents(@ModelAttribute("item") @Valid WorkIncident workIncident, BindingResult result, ModelMap model) {
        workIncidentValidator.validate(workIncident, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Work Incidents");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", workIncident);
            return "product/workIncidentForm";
        }
        workIncidentService.save(workIncident);
        return "redirect: workIncident.list?type=1";
    }

    @RequestMapping(value = {"/workIncident.list", "/"}, method = RequestMethod.GET)
    public String workIncidentList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Work Incident List");
        model.addAttribute("items", workIncidentService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "product/workIncidentList";
    }

    @RequestMapping(value = "workIncident.delete", method = RequestMethod.GET)
    public String getWorkIncidentsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        WorkIncident workIncident = workIncidentService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, workIncident.getWorkIncidentDescription(), "workIncident.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + workIncident.getWorkIncidentDescription());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "workIncident.delete", method = RequestMethod.POST)
    public String deleteWorkIncidents(@Valid ItemDeleteDTO dto) {
        workIncidentService.delete(workIncidentService.get(dto.getId()));
        return "redirect:workIncident.list?type=2";
    }
}
