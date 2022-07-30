package com.cloud.demo.controller;

import com.cloud.demo.domain.Product;
import com.cloud.demo.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:ProductController
 * Package:com.cloud.demo.controller
 * Description:
 *
 * @Date:2021/12/8 16:51
 * @Author:qs@1.com
 */
@RestController
@RequestMapping("/pro")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Product> list() {
        return this.productService.ListProduct();
    }

}
