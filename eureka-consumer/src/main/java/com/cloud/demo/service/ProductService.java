package com.cloud.demo.service;

import com.cloud.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.List;

/**
 * ClassName:ProductService
 * Package:com.cloud.demo.service
 * Description:
 *
 * @Date:2021/12/9 15:17
 * @Author:qs@1.com
 */
@Service
public class ProductService {
    @Autowired
    private LoadBalancerClient loadBalancerClient; // ribbon负载均衡客户端

    public List<Product> ListProduct() {
        ServiceInstance si = loadBalancerClient.choose("eureka-provider");
        StringBuffer sb = new StringBuffer();
        sb.append("http://");
        sb.append(si.getHost());
        sb.append(":");
        sb.append(si.getPort());
        sb.append("/pro/list");
        System.out.println(sb);

        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>(){};
        ResponseEntity<List<Product>> resp = restTemplate.exchange(sb.toString(), HttpMethod.GET, null, typeRef);
        List<Product> proList = resp.getBody();
        return proList;
    }
}
