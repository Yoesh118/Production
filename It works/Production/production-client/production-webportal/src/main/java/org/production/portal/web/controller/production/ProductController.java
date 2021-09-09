/*
 * Copyright 2014 Edward Zengeni.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.production.portal.web.controller.production;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.production.portal.util.AppMessage;
import org.production.portal.util.MessageType;
import org.production.portal.web.controller.BaseController;
import org.production.portal.web.validator.production.ProductValidator;
import org.production.business.domain.production.Product;
import org.production.business.service.production.ProductService;
import org.production.business.util.dto.ItemDeleteDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author  Rachel Makwara
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Resource
    private ProductService productService;
    @Resource
    private ProductValidator productValidator;

    @RequestMapping(value = "/product.form", method = RequestMethod.GET)
    public String productForm(ModelMap model, @RequestParam(required = false) String id) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Create/ Edit Product");
        model.addAttribute("itemDelete", "product.list");
        Product p = new Product();
        if (id != null) {
            p = productService.get(id);
        }
        model.addAttribute("item", p);
        return "product/productForm";
    }

    @RequestMapping(value = "/product.form", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("item") @Valid Product product, BindingResult result, ModelMap model) {
        productValidator.validate(product, result);
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Production::Create/ Edit Product");
            model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Data entry error has occurred").messageType(MessageType.ERROR).build());
            model.addAttribute("item", product);
            model.addAttribute("itemDelete", "product.list");
            return "product/productForm";
        }
        productService.save(product);
        return "redirect: product.list?type=1";
    }

    @RequestMapping(value = {"/product.list", "/"}, method = RequestMethod.GET)
    public String productList(ModelMap model, @RequestParam(required = false) Integer type) {
        model.addAttribute("message", new AppMessage.MessageBuilder().build());
        model.addAttribute("pageTitle", "Production::Product List");
        model.addAttribute("items", productService.getAll());
        if(type != null){
            model.addAttribute("message", AppMessage.getMessage(type));
        }
        return "product/productList";
    }
    
    @RequestMapping(value = "product.delete", method = RequestMethod.GET)
    public String getProductDeleteForm(@RequestParam("id") String id, ModelMap model){
        Product product = productService.get(id);
        ItemDeleteDTO dto = new ItemDeleteDTO(id, product.getName(), "product.list");
        model.addAttribute("item", dto);
        model.addAttribute("message", new AppMessage.MessageBuilder(Boolean.TRUE).message("Are you sure you want to delete this record").messageType(MessageType.WARNING).build());
        model.addAttribute("pageTitle", "Production::Delete "+product.getName()+" Product");
        return "admin/deleteItem";
    }
    
    @RequestMapping(value = "product.delete", method = RequestMethod.POST)
    public String deleteProduct(@Valid ItemDeleteDTO dto){
        productService.delete(productService.get(dto.getId()));
        return "redirect:product.list?type=2";
    }
}
