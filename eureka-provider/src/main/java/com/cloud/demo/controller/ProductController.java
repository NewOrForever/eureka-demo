package com.cloud.demo.controller;

import com.cloud.demo.domain.Product;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Product> list() {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "库里"));
        list.add(new Product(2, "大胡子"));
        list.add(new Product(3, "阿杜"));
        return list;
    }

}
