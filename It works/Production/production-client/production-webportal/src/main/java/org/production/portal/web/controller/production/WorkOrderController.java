package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.business.domain.production.WorkOrder;
import org.production.business.service.production.BatchStatusService;
import org.production.business.service.production.CustomersService;
import org.production.business.service.production.ProductService;
import org.production.business.service.production.WorkOrderService;
import org.production.business.util.dto.ItemDeleteDTO;
//import org.production.business.utils.Customer;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.WorkOrderValidator;
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
@RequestMapping("/workOrder")
public class WorkOrderController extends BaseController {

    @Resource
    private WorkOrderService workOrderService;
    @Resource
    private WorkOrderValidator workOrderValidator;
    @Resource
    private ProductService productService;
    @Resource
    private BatchStatusService batchStatusService;
    @Resource
    private CustomersService customersService;


    public void setUpModel(ModelMap model, WorkOrder item) {
        model.addAttribute("pageTitle", appPrefix + "Create/ Edit Work Order");
        model.addAttribute("workOrder", item);
        model.addAttribute("itemDelete", "workOrder.list");
//        model.addAttribute("customer", Customer.values());
        model.addAttribute("product", productService.getAll());
        model.addAttribute("batchStatus", batchStatusService.getAll());
         model.addAttribute("customers", customersService.getAll());
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.GET)
    public String workOrderForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        WorkOrder p;
        if (id != null) {
            p = workOrderService.get(id);
        } else {
            p = new WorkOrder();
        }

        setUpModel(model, p);
        return "product/workOrderForm";
    }

    @RequestMapping(value = "/item.form", method = RequestMethod.POST)
    public String saveWorkOrders(@ModelAttribute("workOrder") @Valid WorkOrder workOrder, BindingResult result, ModelMap model) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        workOrderValidator.validate(workOrder, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, workOrder);
            return "product/workOrderForm";
        }
        WorkOrder comp = workOrderService.save(workOrder);
        return "redirect:dashboard/profile.htm?type=1&id=" + comp.getWorkOrderId();
    }

    @RequestMapping(value = {"/workOrder.list", "/"}, method = RequestMethod.GET)
    public String workOrderList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", appPrefix + "WorkOrder List");
        model.addAttribute("items", workOrderService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "/workOrderList";
    }

    @RequestMapping(value = "workOrder.delete", method = RequestMethod.GET)
    public String getWorkOrdersDeleteForm(@RequestParam("id") String id, ModelMap model) {
        WorkOrder workOrder = workOrderService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, workOrder.getWorkOrderNo(), "workOrder.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", appPrefix + "Delete " + workOrder.getWorkOrderNo());
        return "admin/deleteItem";
    }

    @RequestMapping(value = "workOrder.delete", method = RequestMethod.POST)
    public String deleteWorkOrders(@Valid ItemDeleteDTO dto) {
        workOrderService.delete(workOrderService.get(dto.getId()));
        return "redirect:workOrder.list?type=2";
    }
}
