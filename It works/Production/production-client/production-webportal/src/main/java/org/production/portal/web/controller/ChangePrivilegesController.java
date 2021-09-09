/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller;

import javax.annotation.Resource;
import org.production.portal.web.validator.UserValidator;
import org.production.business.domain.User;
import org.production.business.service.UserRoleService;
import org.production.business.service.UserService;
import org.production.business.util.dto.ChangePrivilegesDTO;
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
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/admin")
public class ChangePrivilegesController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private UserValidator userValidator;
    @Resource
    private UserRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET, value = "/changeprivileges")
    public String changeUserPrivileges(@RequestParam String id, ModelMap model) {
        User user = userService.get(id);
        ChangePrivilegesDTO userProfile = new ChangePrivilegesDTO(user);
        model.addAttribute("pageTitle", "Production:" + user.getUsername()+ " Change Privileges");
        model.addAttribute("roles", userRoleService.getAll());
        model.addAttribute("item", userProfile);
        return "admin/changePrivilegesForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changeprivileges")
    public String changeUser(ModelMap model, @ModelAttribute("item") ChangePrivilegesDTO details, BindingResult result) throws Exception {
        userValidator.validateChangeprivileges(details, result);
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production:Change Privileges");
            model.addAttribute("item", details);
            return "admin/changePrivilegesForm";
        }
        userService.save(details.getInstance(details));
        return "redirect:../admin/user/?type=1";
    }
}
