package com.javayh.nacos.sentinel.server;

import com.javayh.nacos.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 20:50
 */
@Service
@FeignClient(name = "javayh-nacos-provider",fallback = SentinelFallback.class)
public interface SentinelServer {
    /**
     * 查询
     * @param name
     * @return
     */
    @GetMapping(value = "/provider/find/nacos/{name}")
    Result findNacos(@PathVariable String name);
}

@Component
class SentinelFallback implements SentinelServer{

    /**
     * 服务容错处理
     * @param name
     * @return
     */
    @Override
    public Result findNacos(String name) {
        return Result.javaYhResultFailed("Sentinel fallback param is --->"+name);
    }
}
