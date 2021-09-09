package org.production.portal.web.controller.production;

import org.production.portal.web.controller.admin.*;
import org.apache.log4j.Logger;
import org.production.portal.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminpro")
public class AdminProductionController extends BaseController{

    protected static Logger logger = Logger.getLogger(AdminProductionController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(ModelMap model) {
        logger.info("Received request to show index page (Admin Index)");
        model.addAttribute("pageTitle", "Production: Administration Page Home");
        return "adminpro/index";
    }

}
