package org.production.portal.web.controller.reports;

import java.io.InputStream;
import java.util.ArrayList;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.production.business.domain.District;
import org.production.business.service.DistrictService;

@Controller
public class DistrictReportController {

    @Resource
    private DistrictService districtService;
    @Resource
    private ServletContext servletContext;

    @RequestMapping(value = "getPDF", method = RequestMethod.GET)
    public void generatePDF(String id, HttpServletResponse response) throws Exception {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        for (District district : districtService.getAll()) {
            item.put("name", district.getName());
            item.put("description", district.getDescription());
            item.put("code", district.getDistrictCode());
            result.add(item);
        }
        response.setContentType("application/html");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
        JasperPrint jasperPrint;
        InputStream inputStream = servletContext.getResourceAsStream("/WEB-INF/jsp/reports/district-report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        jasperPrint = JasperFillManager.fillReport(jasperReport, item, dataSource);
        //response.addHeader("Content-disposition", "attachment; filename=Districts.pdf");
        response.setHeader("Content-Disposition", "filename=" + "Districts.pdf");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }

}