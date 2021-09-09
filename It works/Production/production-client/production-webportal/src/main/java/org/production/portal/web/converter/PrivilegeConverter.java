package org.production.portal.web.converter;

import javax.annotation.Resource;
import org.production.business.domain.Privilege;
import org.production.business.service.PrivilegeService;
import org.springframework.core.convert.converter.Converter;

public class PrivilegeConverter implements Converter<String, Privilege> {

    @Resource
    private PrivilegeService privilegeService;

    @Override
    public Privilege convert(String s) {
        if(s.equals("")) return null;
        return privilegeService.get(s);
    }
}
