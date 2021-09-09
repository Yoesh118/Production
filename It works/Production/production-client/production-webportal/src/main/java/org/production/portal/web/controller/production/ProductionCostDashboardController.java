package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ProductionCost;
import org.production.business.service.production.IncidentCostService;
import org.production.business.service.production.OtherService;
import org.production.business.service.production.ProcurementCostService;
import org.production.business.service.production.ProductionCostService;
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
@RequestMapping("/productionCost/dashboard")
public class ProductionCostDashboardController extends BaseController {

    @Resource
    private ProductionCostService productionCostService;
    @Resource
    private OtherService otherService;
    @Resource
    private IncidentCostService incidentCostService;
    @Resource
    private ProcurementCostService procurementCostService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String productionCostProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ProductionCost productionCost = productionCostService.get(id);
        model.addAttribute("pageTitle", appPrefix + productionCost.getName() + "'s Dashboard");
        model.addAttribute("productionCost", productionCost);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
         
        }
           model.addAttribute("procurementCost", procurementCostService.getByProductionCost(productionCost));
            model.addAttribute("other", otherService.getByProductionCost(productionCost));
            model.addAttribute("incidentCost", incidentCostService.getByProductionCost(productionCost));
            
        return "product/productionCostDashboard";
    }
}
