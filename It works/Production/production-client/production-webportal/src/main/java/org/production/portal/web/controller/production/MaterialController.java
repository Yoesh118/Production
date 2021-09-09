package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.Material;
import org.production.business.service.production.MaterialService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.MaterialValidator;
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
@RequestMapping("/material")
public class MaterialController extends BaseController {

    @Resource
    private MaterialService materialService;
    @Resource
    private MaterialValidator materialValidator;


    public void setUpModel(ModelMap model, Material item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Material");
        model.addAttribute("material", item);
        model.addAttribute("itemDelete", "material.list");
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        Material p;
        if (id != null) {
            p = materialService.get(id);
        } else {
            p = new Material();
        }

        setUpModel(model, p);
        return "product/materialForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveMaterials(@ModelAttribute("material") @Valid Material material, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        materialValidator.validate(material, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, material);
            return "product/materialForm";
        }
        Material comp = materialService.save(material);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getMaterialId();
    }

    @RequestMapping(value = {"/material.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Material List");
        model.addAttribute("items", materialService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/materialList";
    }

    @RequestMapping(value = "material.delete", method = RequestMethod.GET)
    public String getMaterialsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Material material = materialService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, material.getName(), "material.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + material.getName() + " Materials");
        return "admin/deleteItem";
    }

    @RequestMapping(value = "material.delete", method = RequestMethod.POST)
    public String deleteMaterials(@Valid ItemDeleteDTO dto) {
        materialService.delete(materialService.get(dto.getId()));
        return "redirect:material.list?type=2";
    }
}
