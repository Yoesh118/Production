package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessPlan;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.ProcessPlanService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessPlanValidator;
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
@RequestMapping("/processPlan")
public class ProcessPlanController extends BaseController {

    @Resource
    private ProcessPlanService processPlanService;
    @Resource
    private ProcessPlanValidator processPlanValidator;
    @Resource
    private BatchStatusService batchStatusService;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private ProcessingPlantService processingPlantService;


    public void setUpModel(ModelMap model, ProcessPlan item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit ProcessPlan");
        model.addAttribute("processPlan", item);
        model.addAttribute("itemDelete", "processPlan.list");
        model.addAttribute("batchStatus", batchStatusService.getAll());
        model.addAttribute("productWarehouse", productWarehouseService.getAll());
        model.addAttribute("processingPlant", processingPlantService.getAll());
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        ProcessPlan p;
        if (id != null) {
            p = processPlanService.get(id);
        } else {
            p = new ProcessPlan();
        }

        setUpModel(model, p);
        return "product/processPlanForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveProcessPlans(@ModelAttribute("processPlan") @Valid ProcessPlan processPlan, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        processPlanValidator.validate(processPlan, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processPlan);
            return "product/processPlanForm";
        }
        ProcessPlan comp = processPlanService.save(processPlan);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getProcessPlanId();
    }

    @RequestMapping(value = {"/processPlan.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Process Plan List");
        model.addAttribute("items", processPlanService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/processPlanList";
    }

    @RequestMapping(value = "processPlan.delete", method = RequestMethod.GET)
    public String getProcessPlansDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessPlan processPlan = processPlanService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processPlan.getOrderNo(), "processPlan.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + processPlan.getOrderNo());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "processPlan.delete", method = RequestMethod.POST)
    public String deleteProcessPlans(@Valid ItemDeleteDTO dto) {
        processPlanService.delete(processPlanService.get(dto.getId()));
        return "redirect:processPlan.list?type=2";
    }
}
