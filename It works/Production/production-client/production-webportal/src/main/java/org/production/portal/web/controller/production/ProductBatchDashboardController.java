package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import org.production.business.domain.production.ProductBatch;
import org.production.business.service.production.ProductBatchService;
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
@RequestMapping("/productBatch/dashboard")
public class ProductBatchDashboardController extends BaseController {

    @Resource
    private ProductBatchService productBatchService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String productBatchProfileTabs(ModelMap model, @RequestParam String id, @RequestParam(required = false) Integer type) {
        ProductBatch productBatch = productBatchService.get(id);
        model.addAttribute("pageTitle", appPrefix + productBatch.getBatchDescription() + "'s Dashboard");
        model.addAttribute("productBatch", productBatch);
        if (type != null) {
            model.addAttribute("message", AppMessage.getMessage(type));
        }
      //  model.addAttribute("banks", productBatchBankDetailService.getByProductBatch(productBatch));
        //model.addAttribute("contacts", productBatchContactService.getByProductBatch(productBatch));
        return "product/productBatchDashboard";
    }
}
