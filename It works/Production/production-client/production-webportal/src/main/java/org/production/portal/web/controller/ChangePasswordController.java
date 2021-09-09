/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller;


import javax.annotation.Resource;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.validator.UserValidator;
import org.production.business.domain.User;
import org.production.business.service.UserService;
import org.production.business.util.dto.ChangePasswordDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/admin")
public class ChangePasswordController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private UserValidator userValidator;

    @RequestMapping(method = RequestMethod.GET, value = "/changepassword")
    public String changeUserPassword(@RequestParam String id, ModelMap model) {
        User user = userService.get(id);
        if(!user.equals(userService.getCurrentUser())){
            throw new IllegalStateException("User loaded not current user, refer to administrator for details");
        }
        ChangePasswordDTO userProfile = new ChangePasswordDTO(user);
        model.addAttribute("pageTitle", "Production:"+user.getUsername()+" Change Password");
        model.addAttribute("item", userProfile);
        return "admin/changePasswordForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changepassword")
    public String changeUser(ModelMap model, @ModelAttribute("item") ChangePasswordDTO details, BindingResult result, RedirectAttributes attr) throws Exception  {
        userValidator.validateChangepassword(details, result);
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Change Password");
            model.addAttribute("item", details);
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            return "admin/changePasswordForm";
        }
        userService.changePassword(details.getInstance(details));
        return "redirect:../?type=4";
    }
}