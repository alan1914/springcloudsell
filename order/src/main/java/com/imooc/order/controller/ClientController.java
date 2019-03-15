package com.imooc.order.controller;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        // 1. 第一种方式（直接使用restTemplate， url 写死）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:9000/msg",String.class);

        // 2. 第二种方式（利用LoadBalancerClient 通过应用名获取url, 然后再使用 restTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort()+"/msg");
//        String response = restTemplate.getForObject(url,String.class);

        // 3. 第三种方式(利用@LoadBalanced,可在restTemplate 里使用引用名称)
//        String response = restTemplate.getForObject("http://PRODUCT/msg",String.class);

        // 4. 第四种方法 feign 获取
        String response = productClient.productMsg();

        log.info("response={}",response);
        return response;

    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));;
        log.info("response={}",list);
        return "ok";
    }

    @GetMapping("/produceDecreaseStock")
    public String produceDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022",2)));
        return "ok";
    }



}
