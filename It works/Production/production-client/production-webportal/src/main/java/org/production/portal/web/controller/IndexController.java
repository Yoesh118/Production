package org.production.portal.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.production.business.service.CompanyService;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.business.service.DistrictService;
import org.production.business.service.ProvinceService;
import org.production.business.service.StationService;
import org.production.business.service.UserService;
import org.production.business.service.production.ProductService;
import org.production.business.util.dto.SearchDTO;
import org.production.business.util.dto.UserLevel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author  Rachel Makwara
 */
@Controller
public class IndexController extends BaseController {

    @Resource
    ProvinceService provinceService;
    @Resource
    DistrictService districtService;
    @Resource
    CompanyService companyService;
    @Resource
    StationService stationService;
    @Resource
    ProductService productService;
    @Resource
    private UserService userService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(ModelMap model) {
        model.addAttribute("pageTitle", appPrefix + "HOME");
        SearchDTO dto = new SearchDTO();
        model.addAttribute("item", SearchDTO.getInstance(dto));
        if (userService.getCurrentUser().getUserLevel().equals(UserLevel.PROVINCE)) {
            dto.setProvince(userService.getCurrentUser().getProvince());
            model.addAttribute("districts", districtService.getDistrictByProvince(userService.getCurrentUser().getProvince()));
            return "province";
        } else if (userService.getCurrentUser().getUserLevel().equals(UserLevel.DISTRICT)) {
            model.addAttribute("stations", stationService.getByDistrict(userService.getCurrentUser().getDistrict()));
            dto.setDistrict(userService.getCurrentUser().getDistrict());
            return "district";
        }
        model.addAttribute("provinces", provinceService.getAll());
        return "national";
    }

    @RequestMapping(value = "/login")
    public String getLogin(ModelMap model) {
        model.addAttribute("pageTitle", appPrefix + "Login");
        return "login";
    }

    @RequestMapping(value = "/loginfailed")
    public String getloginFailed() {
        return "redirect:loginerror";
    }

    @RequestMapping(value = "/loginerror", method = RequestMethod.GET)
    public String getRedirectError(ModelMap model) {
        model.addAttribute("pageTitle", appPrefix + "Access Denied");
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Error worng username/ password").messageType(MessageType.ERROR).build());
        return "login";
    }

    @RequestMapping(value = "/success")
    public String getSuccess(ModelMap model) {
        model.addAttribute("message", appPrefix + "Access accepted");
        return "index";
    }

    @RequestMapping(value = "/logout")
    public String logout(ModelMap model, HttpSession httpSession) {
        model.addAttribute("message", appPrefix + "Access Failed");
        httpSession.invalidate();
        return "redirect:login";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String loadEmployees(ModelMap model, @ModelAttribute("item") SearchDTO dto) {
        model.addAttribute("pageTitle", appPrefix + "Home");
        model.addAttribute("provinces", provinceService.getAll());
        if (!dto.getSearch()) {
        } else if (dto.getSearch()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Please make at least one selection").messageType(MessageType.ERROR).build());
        }
        if (userService.getCurrentUser().getUserLevel().equals(UserLevel.PROVINCE)) {
            model.addAttribute("districts", districtService.getDistrictByProvince(userService.getCurrentUser().getProvince()));
            return "province";
        } else if (userService.getCurrentUser().getUserLevel().equals(UserLevel.DISTRICT)) {
            model.addAttribute("stations", stationService.getByDistrict(userService.getCurrentUser().getDistrict()));
            return "district";
        }
        if (dto.getProvince() != null) {
            model.addAttribute("districts", districtService.getDistrictByProvince(dto.getProvince()));
            if (dto.getDistrict() != null) {
                model.addAttribute("stations", stationService.getByDistrict(dto.getDistrict()));
            }
        }
        model.addAttribute("item", SearchDTO.getInstance(dto));
        return "index";
    }

    @RequestMapping(value = "/companies")
    public String getManagePayroll(ModelMap model) {
        model.addAttribute("pageTitle", "Company: Companies");
        model.addAttribute("items", companyService.getAll());
        model.addAttribute("excelExport", "/excel/all-employee-report.htm");
        model.addAttribute("pdfExport", "/pdf/all-employee-report.htm");
        model.addAttribute("wordExport", "/word/all-employee-report.htm");
        return "manageCompany";
    }

    @RequestMapping(value = "/products")
    public String getManageProduct(ModelMap model) {
        model.addAttribute("pageTitle", "Production: Products");
        model.addAttribute("items", productService.getAll());
        model.addAttribute("excelExport", "/excel/all-employee-report.htm");
        model.addAttribute("pdfExport", "/pdf/all-employee-report.htm");
        model.addAttribute("wordExport", "/word/all-employee-report.htm");
        return "manageProduct";
    }

}
