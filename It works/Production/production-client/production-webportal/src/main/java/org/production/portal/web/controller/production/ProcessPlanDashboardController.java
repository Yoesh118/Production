package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ProcessPlan;
import org.production.business.service.production.ProcessPlanService;
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
@RequestMapping("/processPlan/dashboard")
public class ProcessPlanDashboardController extends BaseController {

    @Resource
    private ProcessPlanService processPlanService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String processPlanProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ProcessPlan processPlan = processPlanService.get(id);
        model.addAttribute("pageTitle", appPrefix + processPlan.getOrderNo() + "'s Dashboard");
        model.addAttribute("processPlan", processPlan);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/processPlanDashboard";
    }
}
