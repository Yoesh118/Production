package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.AssetMaintanance;
import org.production.business.service.production.AssetMaintananceService;
import org.production.business.service.production.BatchStatusService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.AssetMaintananceValidator;
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
@RequestMapping("/assetMaintanance")
public class AssetMaintananceController extends BaseController {

    @Resource
    private AssetMaintananceService assetMaintananceService;
    @Resource
    private AssetMaintananceValidator assetMaintananceValidator;
   @Resource
    private BatchStatusService batchStatusService;


    public void setUpModel(ModelMap model, AssetMaintanance item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Asset Maintanance");
        model.addAttribute("assetMaintanance", item);
        model.addAttribute("itemDelete", "assetMaintanance.list");
        model.addAttribute("batchStatus", batchStatusService.getAll());
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        AssetMaintanance p;
        if (id != null) {
            p = assetMaintananceService.get(id);
        } else {
            p = new AssetMaintanance();
        }

        setUpModel(model, p);
        return "product/assetMaintananceForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveAssetMaintanances(@ModelAttribute("assetMaintanance") @Valid AssetMaintanance assetMaintanance, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        assetMaintananceValidator.validate(assetMaintanance, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, assetMaintanance);
            return "product/assetMaintananceForm";
        }
        AssetMaintanance comp = assetMaintananceService.save(assetMaintanance);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getAssetMaintananceId();
    }

    @RequestMapping(value = {"/assetMaintanance.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Asset Maintanance List");
        model.addAttribute("items", assetMaintananceService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/assetMaintananceList";
    }

    @RequestMapping(value = "assetMaintanance.delete", method = RequestMethod.GET)
    public String getAssetMaintanancesDeleteForm(@RequestParam("id") String id, ModelMap model) {
        AssetMaintanance assetMaintanance = assetMaintananceService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, assetMaintanance.getAssetMaintananceProduct(), "assetMaintanance.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + assetMaintanance.getAssetMaintananceProduct());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "assetMaintanance.delete", method = RequestMethod.POST)
    public String deleteAssetMaintanances(@Valid ItemDeleteDTO dto) {
        assetMaintananceService.delete(assetMaintananceService.get(dto.getId()));
        return "redirect:assetMaintanance.list?type=2";
    }
}
