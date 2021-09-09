package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.ProductBatch;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.production.ProductBatchService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductBatchValidator;
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
@RequestMapping("/productBatch")
public class ProductBatchController extends BaseController {

    @Resource
    private ProductBatchService productBatchService;
    @Resource
    private ProductBatchValidator productBatchValidator;
    @Resource
    private BatchStatusService batchStatusService;
    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private ProcessingPlantService processingPlantService;


    public void setUpModel(ModelMap model, ProductBatch item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Product Batch");
        model.addAttribute("productBatch", item);
        model.addAttribute("itemDelete", "productBatch.list");
        model.addAttribute("batchStatus", batchStatusService.getAll());
        model.addAttribute("productWarehouse", productWarehouseService.getAll());
        model.addAttribute("processingPlant", processingPlantService.getAll());
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String productBatchForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        ProductBatch p;
        if (id != null) {
            p = productBatchService.get(id);
        } else {
            p = new ProductBatch();
        }

        setUpModel(model, p);
        return "product/productBatchForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveProductBatchs(@ModelAttribute("productBatch") @Valid ProductBatch productBatch, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        productBatchValidator.validate(productBatch, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, productBatch);
            return "product/productBatchForm";
        }
        ProductBatch comp = productBatchService.save(productBatch);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getProductBatchId();
    }

    @RequestMapping(value = {"/productBatch.list", "/"}, method = RequestMethod.GET)
    public String productBatchList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "Product Batch List");
        model.addAttribute("items", productBatchService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/productBatchList";
    }

    @RequestMapping(value = "productBatch.delete", method = RequestMethod.GET)
    public String getProductBatchsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        ProductBatch productBatch = productBatchService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, productBatch.getProductBatchName(), "productBatch.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + productBatch.getProductBatchName());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "productBatch.delete", method = RequestMethod.POST)
    public String deleteProductBatchs(@Valid ItemDeleteDTO dto) {
        productBatchService.delete(productBatchService.get(dto.getId()));
        return "redirect:productBatch.list?type=2";
    }
}
