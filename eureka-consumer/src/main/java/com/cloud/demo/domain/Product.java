package com.cloud.demo.domain;

/**
 * ClassName:Product
 * Package:com.cloud.demo.controller
 * Description:
 *
 * @Date:2021/12/8 16:52
 * @Author:qs@1.com
 */

public class Product {
    private Integer id;
    private String name;

    public Product(){

    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
