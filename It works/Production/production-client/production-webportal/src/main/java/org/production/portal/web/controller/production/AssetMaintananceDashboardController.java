package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.AssetMaintanance;
import org.production.business.service.production.AssetMaintananceService;
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
@RequestMapping("/assetMaintanance/dashboard")
public class AssetMaintananceDashboardController extends BaseController {

    @Resource
    private AssetMaintananceService assetMaintananceService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String assetMaintananceProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        AssetMaintanance assetMaintanance = assetMaintananceService.get(id);
        model.addAttribute("pageTitle", appPrefix + assetMaintanance.getAssetMaintananceProduct() + "'s Dashboard");
        model.addAttribute("assetMaintanance", assetMaintanance);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/assetMaintananceDashboard";
    }
}
