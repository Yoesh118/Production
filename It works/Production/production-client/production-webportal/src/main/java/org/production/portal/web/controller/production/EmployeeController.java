package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.EmployeeValidator;
import org.production.business.domain.production.Employee;
import org.production.business.service.production.EmployeeService;
import org.production.business.service.production.ProductionTeamService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController{

    @Resource
    private EmployeeService employeeService;
    @Resource
    private EmployeeValidator employeeValidator;
    @Resource
    private ProductionTeamService productionTeamService;


    @RequestMapping(value = "/employee.form", method = RequestMethod.GET)
    public String employeeForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Employee");
        model.addAttribute("productionTeam", productionTeamService.getAll());
        Employee p = new Employee();
        if (id != null) {
            p = employeeService.get(id);
        }
        model.addAttribute("item", p);
        model.addAttribute("itemDelete", "employee.list?type=3");
        return "product/employeeForm";
    }

    @RequestMapping(value = "/employee.form", method = RequestMethod.POST)
    public String saveEmployees(@ModelAttribute("item") @Valid Employee employee, BindingResult result, ModelMap model) {
        employeeValidator.validate(employee, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Employee");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());

            model.addAttribute("item", employee);
            return "product/employeeForm";
        }
        employeeService.save(employee);
        return "redirect: employee.list?type=1";
    }

    @RequestMapping(value = {"/employee.list", "/"}, method = RequestMethod.GET)
    public String employeeList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Employees List");
        model.addAttribute("items", employeeService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "product/employeeList";
    }

    @RequestMapping(value = "employee.delete", method = RequestMethod.GET)
    public String getEmployeesDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Employee employee = employeeService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, employee.getEmployeeId(), "employee.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + employee.getEmployeeId() + " Employees");
        return "admin/deleteItem";
    }

    @RequestMapping(value = "employee.delete", method = RequestMethod.POST)
    public String deleteEmployees(@Valid ItemDeleteDTO dto) {
        employeeService.delete(employeeService.get(dto.getId()));
        return "redirect:employee.list?type=2";
    }
}
