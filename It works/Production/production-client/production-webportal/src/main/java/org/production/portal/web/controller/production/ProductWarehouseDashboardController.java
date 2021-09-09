package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ProductWarehouse;
import org.production.business.service.production.ProductWarehouseMachineryService;
import org.production.business.service.production.ProductWarehousePosService;
import org.production.business.service.production.ProductWarehouseProductService;
import org.production.business.service.production.ProductWarehouseProductionTeamService;
import org.production.business.service.production.ProductWarehouseService;
import org.production.business.service.production.ProductWarehouseToolsService;
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
@RequestMapping("/productWarehouse/dashboard")
public class ProductWarehouseDashboardController extends BaseController {

    @Resource
    private ProductWarehouseService productWarehouseService;
    @Resource
    private ProductWarehouseToolsService productWarehouseToolsService;
    @Resource
    private ProductWarehouseMachineryService productWarehouseMachineryService;
    @Resource
    private ProductWarehousePosService productWarehousePosService;
    @Resource
    private ProductWarehouseProductService productWarehouseProductService;
    @Resource
    private ProductWarehouseProductionTeamService productWarehouseProductionTeamService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String productWarehouseProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ProductWarehouse productWarehouse = productWarehouseService.get(id);
        model.addAttribute("pageTitle", appPrefix + productWarehouse.getWarehouseName() + "'s Dashboard");
        model.addAttribute("productWarehouse", productWarehouse);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
         
        }
           model.addAttribute("tools", productWarehouseToolsService.getByProductWarehouse(productWarehouse));
            model.addAttribute("warehouseMachinery", productWarehouseMachineryService.getByProductWarehouse(productWarehouse));
            model.addAttribute("pos", productWarehousePosService.getByProductWarehouse(productWarehouse));
            model.addAttribute("product", productWarehouseProductService.getByProductWarehouse(productWarehouse));
            model.addAttribute("productionTeam", productWarehouseProductionTeamService.getByProductWarehouse(productWarehouse));
        return "product/productWarehouseDashboard";
    }
}
