package com.yangtao.springcloud.controller;

import com.yangtao.springcloud.pojo.CommonResult;
import com.yangtao.springcloud.pojo.Payment;
import com.yangtao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：杨涛
 * @create: 2021-04-08 17:22
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @RequestMapping("/getOne/{id}")
    public CommonResult<Payment> getOne(@PathVariable("id") Integer id){
        Payment byId = service.getById(id);
        if (byId != null){
            return new CommonResult(200,"查询数据成功,serverPort:"+serverPort,byId);
        }else {
            return new CommonResult(444,"数据失败"+id,null);
        }
    }


    @RequestMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        int add = service.add(payment);
        if (add>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,add);
        }else {
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/discover")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String ele: services) {
            log.info("ele : "+ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance ins: instances) {
            log.info("ins : id--"+ins.getServiceId()+"--主机--"+ins.getHost()+"--端口--"+ins.getPort()+"--uri--"+ins.getUri());
        }
        return this.discoveryClient;
    }
}
