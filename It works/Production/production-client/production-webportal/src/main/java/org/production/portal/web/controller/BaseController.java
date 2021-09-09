package org.production.portal.web.controller;

import javax.annotation.Resource;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.business.domain.User;
import org.production.business.service.UserService;
import org.production.business.util.dto.SearchDTO;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author  Rachel Makwara
 */
abstract public class BaseController {

    @Resource
    private UserService userService;
    public String appPrefix = getTitleContext(" : ");
    private final static Logger logger = org.slf4j.LoggerFactory.getLogger(BaseController.class);

    @ModelAttribute("currentuser")
    public User getUserName() {
        return userService.getCurrentUser();
    }

    public AppMessage getMessage(Integer type) {
        switch (type) {
            case 1:
                return new AppMessage.MessageBuilder(Boolean.TRUE).message("Record saved").messageType(MessageType.MESSAGE).build();
            case 2:
                return new AppMessage.MessageBuilder(Boolean.TRUE).message("Record deleted").messageType(MessageType.MESSAGE).build();
            case 3:
                return new AppMessage.MessageBuilder(Boolean.TRUE).message("Operation cancelled").messageType(MessageType.MESSAGE).build();
            default:
                throw new IllegalArgumentException("Parameter provided not recognised :" + type);
        }
    }

    private String getTitleContext(String desc) {
        if (userService == null) {
            return "CICOSY Production:";
        }
        SearchDTO dto = new SearchDTO();
        User user = getUserName();
        if (user == null) {
            return "CICOSY Production:";
        } else {
            dto.setDistrict(user.getDistrict());
            dto.setProvince(user.getProvince());
            dto.setStation(user.getStation());
            return getTitle(dto, desc);
        }
    }

    public String getTitle(SearchDTO dto, String desc) {
        if (dto.getStation() != null) {
            return dto.getStation().getName() + " Station " + desc;
        } else if (dto.getDistrict() != null) {
            return dto.getDistrict().getName() + " District " + desc;
        } else if (dto.getProvince() != null) {
            return dto.getProvince().getName() + " Province " + desc;
        }
        return "National " + desc;
    }
}
