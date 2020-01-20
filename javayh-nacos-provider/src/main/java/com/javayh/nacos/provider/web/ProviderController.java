package com.javayh.nacos.provider.web;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 17:01
 */

import com.javayh.nacos.common.result.Result;
import com.javayh.nacos.provider.server.NacosProviderServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RefreshScope
@RestController
@RequestMapping(value = "/provider/")
public class ProviderController {
    @Autowired
    private NacosProviderServer nacosProviderServer;

    @Value("${user}")
    private String user;

    @GetMapping(value = "/find/nacos/{name}")
    public Result find(@PathVariable String name){
        return Result.querySuccess(nacosProviderServer.findNacos(name));
    }
    @GetMapping(value = "getConfig")
    public Result getConfig(){
        return Result.querySuccess(user);
    }
}
