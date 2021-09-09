package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ProcessingPlant;
import org.production.business.service.production.ProcessingPlantMachineryService;
import org.production.business.service.production.ProcessingPlantMaterialService;
import org.production.business.service.production.ProcessingPlantProductionRunService;
import org.production.business.service.production.ProcessingPlantProductionTeamService;
import org.production.business.service.production.ProcessingPlantService;
import org.production.business.service.production.ProcessingPlantToolsService;
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
@RequestMapping("/processingPlant/dashboard")
public class ProcessingPlantDashboardController extends BaseController {

    @Resource
    private ProcessingPlantService processingPlantService;
    @Resource
    private ProcessingPlantToolsService processingPlantToolsService;
    @Resource
    private ProcessingPlantMachineryService processingPlantMachineryService;
    @Resource
    private ProcessingPlantMaterialService processingPlantMaterialService;
    @Resource
    private ProcessingPlantProductionRunService processingPlantProductionRunService;
    @Resource
    private ProcessingPlantProductionTeamService processingPlantProductionTeamService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String processingPlantProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ProcessingPlant processingPlant = processingPlantService.get(id);
        model.addAttribute("pageTitle", appPrefix + processingPlant.getProcessingPlantName() + "'s Dashboard");
        model.addAttribute("processingPlant", processingPlant);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        
            model.addAttribute("tools", processingPlantToolsService.getByProcessingPlant(processingPlant));
            model.addAttribute("machinery", processingPlantMachineryService.getByProcessingPlant(processingPlant));
            model.addAttribute("material", processingPlantMaterialService.getByProcessingPlant(processingPlant));
            model.addAttribute("productionRun", processingPlantProductionRunService.getByProcessingPlant(processingPlant));
            model.addAttribute("productionTeam", processingPlantProductionTeamService.getByProcessingPlant(processingPlant));
        return "product/processingPlantDashboard";
    }
}
