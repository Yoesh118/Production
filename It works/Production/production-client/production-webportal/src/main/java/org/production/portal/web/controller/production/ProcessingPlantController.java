package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProcessingPlantValidator;
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
@RequestMapping("/processingPlant")
public class ProcessingPlantController extends BaseController {

    @Resource
    private ProcessingPlantService processingPlantService;
    @Resource
    private ProcessingPlantValidator processingPlantValidator;


    public void setUpModel(ModelMap model, ProcessingPlant item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Processing Plant");
        model.addAttribute("processingPlant", item);
        model.addAttribute("itemDelete", "processingPlant.list");
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        ProcessingPlant p;
        if (id != null) {
            p = processingPlantService.get(id);
        } else {
            p = new ProcessingPlant();
        }

        setUpModel(model, p);
        return "product/processingPlantForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveProcessingPlants(@ModelAttribute("processingPlant") @Valid ProcessingPlant processingPlant, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        processingPlantValidator.validate(processingPlant, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, processingPlant);
            return "product/processingPlantForm";
        }
        ProcessingPlant comp = processingPlantService.save(processingPlant);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getProcessingPlantId();
    }

    @RequestMapping(value = {"/processingPlant.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Processing Plant List");
        model.addAttribute("items", processingPlantService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/processingPlantList";
    }

    @RequestMapping(value = "processingPlant.delete", method = RequestMethod.GET)
    public String getProcessingPlantsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProcessingPlant processingPlant = processingPlantService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, processingPlant.getProcessingPlantId(), "processingPlant.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + processingPlant.getProcessingPlantId());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "processingPlant.delete", method = RequestMethod.POST)
    public String deleteProcessingPlants(@Valid ItemDeleteDTO dto) {
        processingPlantService.delete(processingPlantService.get(dto.getId()));
        return "redirect:processingPlant.list?type=2";
    }
}
