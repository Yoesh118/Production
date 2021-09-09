package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.Material;
import org.production.business.service.production.MaterialService;
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
@RequestMapping("/material/dashboard")
public class MaterialDashboardController extends BaseController {

    @Resource
    private MaterialService materialService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String materialProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        Material material = materialService.get(id);
        model.addAttribute("pageTitle", appPrefix + material.getName() + "'s Dashboard");
        model.addAttribute("material", material);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/materialDashboard";
    }
}
