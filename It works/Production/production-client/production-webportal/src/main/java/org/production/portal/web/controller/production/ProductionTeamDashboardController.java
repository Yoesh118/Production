package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ProductionTeam;
import org.production.business.service.production.ProductionTeamService;
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
@RequestMapping("/productionTeam/dashboard")
public class ProductionTeamDashboardController extends BaseController {

    @Resource
    private ProductionTeamService productionTeamService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String productionTeamProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ProductionTeam productionTeam = productionTeamService.get(id);
        model.addAttribute("pageTitle", appPrefix + productionTeam.getProductionTeamName() + "'s Dashboard");
        model.addAttribute("productionTeam", productionTeam);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/productionTeamDashboard";
    }
}
