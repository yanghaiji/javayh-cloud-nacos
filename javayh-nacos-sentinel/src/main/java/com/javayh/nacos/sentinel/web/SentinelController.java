package com.javayh.nacos.sentinel.web;

import com.javayh.nacos.common.result.Result;
import com.javayh.nacos.sentinel.server.SentinelServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 20:37
 */
@RestController
public class SentinelController {

    @Autowired private SentinelServer sentinelServer;
    /**
     * 测试 sentinel 与 feign整合
     * @param str
     * @return
     */
    @GetMapping(value = "getSentinel/{str}")
    public Result getSentinel(@PathVariable String str){
        return Result.javaYhQuerySuccess(sentinelServer.findNacos(str));
    }

}
