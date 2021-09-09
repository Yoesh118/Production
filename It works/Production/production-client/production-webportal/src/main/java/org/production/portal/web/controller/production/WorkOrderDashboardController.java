package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.WorkOrder;
import org.production.business.service.production.WorkOrderService;
import org.production.portal.util.AppMessage;
import org.production.portal.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/workOrder/dashboard")
public class WorkOrderDashboardController extends BaseController {

    @Resource
    private WorkOrderService workOrderService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String workOrderProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        WorkOrder workOrder = workOrderService.get(id);
        model.addAttribute("pageTitle", appPrefix + workOrder.getWorkOrderNo() + "'s Dashboard");
        model.addAttribute("workOrder", workOrder);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/workOrderDashboard";
    }
}
