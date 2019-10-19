package com.javayh.nacos.provider.server;

import com.javayh.nacos.common.id.IdUtils;
import com.javayh.nacos.common.model.SysNacos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Dylan Yang
 * @Description: 生产者
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 16:14
 */
@Slf4j
@Service
public class NacosProviderServer {

    @GetMapping(value = "/find/nacos/{name}")
    public SysNacos findNacos(@PathVariable String name){
        SysNacos sysNacos = SysNacos.builder().
                id(IdUtils.uuid()).
                name(name).
                pwd(IdUtils.uuid()).
                build();
        log.info("服务调用成功 ={}",sysNacos);
        return sysNacos;
    }
}
