package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ClientMaintanance;
import org.production.business.service.production.ClientMaintananceService;
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
@RequestMapping("/clientMaintanance/dashboard")
public class ClientMaintananceDashboardController extends BaseController {

    @Resource
    private ClientMaintananceService clientMaintananceService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String clientMaintananceProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ClientMaintanance clientMaintanance = clientMaintananceService.get(id);
        model.addAttribute("pageTitle", appPrefix + clientMaintanance.getClientMaintananceProduct() + "'s Dashboard");
        model.addAttribute("clientMaintanance", clientMaintanance);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/clientMaintananceDashboard";
    }
}
