/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.production.portal.web.controller.admin;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.StationValidator;
import org.production.business.domain.Station;
import org.production.business.service.DistrictService;
import org.production.business.service.ProvinceService;
import org.production.business.service.StationCategoryService;
import org.production.business.service.StationService;
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
@RequestMapping("/admin/station")
public class StationController extends BaseController {
    
    @Resource
    private StationService stationService;
    @Resource
    private StationValidator stationValidator;
    @Resource
    private StationCategoryService stationCategoryService;
    @Resource
    private ProvinceService provinceService;
    @Resource
    private DistrictService districtService;
    
    public void setUpModel(ModelMap model, Station item) {
        model.addAttribute("pageTitle", "Production::Create/ Edit Stations");
        model.addAttribute("provinces", provinceService.getAll());
        model.addAttribute("stationCategories", stationCategoryService.getAll());
        if (item.getDistrict() != null) {
            item.setProvince(item.getDistrict().getProvince());
        }
        if (item.getProvince() != null) {
            model.addAttribute("districts", districtService.getDistrictByProvince(item.getProvince()));
        }
        model.addAttribute("item", item);
        model.addAttribute("itemDelete", "station.list?type=3");
    }
    
    @RequestMapping(value = "/station.form", method = RequestMethod.GET)
    public String stationForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        Station p = new Station();
        if (id != null) {
            p = stationService.get(id);
        }
        setUpModel(model, p);
        return "admin/stationForm";
    }
    
    @RequestMapping(value = "/station.form", method = RequestMethod.POST)
    public String saveStations(@ModelAttribute("item") @Valid Station station, BindingResult result, ModelMap model) {
        stationValidator.validate(station, result);
        if (result.hasErrors()) {
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            setUpModel(model, station);
            return "admin/stationForm";
        }
        stationService.save(station);
        return "redirect: station.list?type=1";
    }
    
    @RequestMapping(value = {"/station.list", "/"}, method = RequestMethod.GET)
    public String stationList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Stations List");
        model.addAttribute("items", stationService.getAll());
        if (type != null) {
            model.addAttribute("message", getMessage(type));
        }
        return "admin/stationList";
    }
    
    @RequestMapping(value = "station.delete", method = RequestMethod.GET)
    public String getStationsDeleteForm(@RequestParam("id") String id, ModelMap model) {
        Station station = stationService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, station.getName(), "station.list?type=3");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete " + station.getName() + " Stations");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "station.delete", method = RequestMethod.POST)
    public String deleteStations(@Valid ItemDeleteDTO dto) {
        stationService.delete(stationService.get(dto.getId()));
        return "redirect:station.list?type=2";
    }
    
}
