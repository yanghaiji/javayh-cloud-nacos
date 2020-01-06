package com.javayh.nacos.consumer.web;

import com.javayh.nacos.common.result.Result;
import com.javayh.nacos.consumer.service.NacosConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 16:28
 */
@RestController
@RequestMapping(value = "/consumer/")
public class NacosController {
    @Autowired
    private NacosConsumer nacosConsumer;

    @GetMapping("find/{name}")
    public Result find(@PathVariable String name){
        return nacosConsumer.findNacos(name);
    }
    @GetMapping("test")
    public Result teset(){
        return Result.javaYhQuerySuccess("Java有货");
    }
}
