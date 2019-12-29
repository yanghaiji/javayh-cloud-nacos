package com.javayh.nacos.tc.web;

import com.javayh.nacos.tc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName javayh-cloud-nacos → com.javayh.nacos.tc.web → TestController
 * @Description test
 * @Author Dylan
 * @Date 2019/12/29 15:02
 * @Version
 */
@RestController
@RequestMapping("/ds/")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public void get(){
        testService.get();
    }
}
