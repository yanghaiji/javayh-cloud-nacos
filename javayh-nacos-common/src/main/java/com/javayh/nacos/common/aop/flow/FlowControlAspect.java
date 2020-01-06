package com.javayh.nacos.common.aop.flow;

import com.javayh.nacos.common.id.IdUtils;
import com.javayh.nacos.common.ip.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Dylan Yang
 * @Description: 流水记录
 * @ProjectName javayh-cloud-nacos
 * @date 2020-01-06 20:41
 */
@Slf4j
@Aspect
@Component
public class FlowControlAspect {

    /*时间格式*/
    private static String YMDMHS = "yyyy-MM-dd HH:mm:ss";
    @Value(value = "${spring.application.name}")
    private String serverName;

    /**
     * @Description 切点为请求路径，包含以下请求方式是
     * @UserModule: javayh     
     * @author Dylan
     * @date 2020/1/6 0006
     * @param [] 
     * @return void
     */
    @Pointcut(value =  "@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
                        "@annotation(org.springframework.web.bind.annotation.PostMapping) ||" +
                        "@annotation(org.springframework.web.bind.annotation.PutMapping) ||" +
                        "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||" +
                        "@annotation(org.springframework.web.bind.annotation.RequestMapping) ")
    public void  flowControl(){

    }

    /**
     * @Description 环绕式实现
     * @UserModule: javayh     
     * @author Dylan
     * @date 2020/1/6 0006
     * @param [joinPoint] 
     * @return java.lang.Object
     */
    @Around(value = "flowControl()")
    public Object flowControl(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        long time = System.currentTimeMillis();
        try {
            proceed = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            log.info("方法执行消耗时间 = " + time);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //方法执行后
            saveFlowControl(joinPoint);
        }
        return proceed;
    }

    private void saveFlowControl(ProceedingJoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取 URL
        String url = request.getRequestURL().toString();
        //获取调用者的IP
        String ip = IPUtils.getRemoteHost(request);
        //调用的时间
        String date = DateFormatUtils.format(new Date(), YMDMHS);
        FlowControLog controLog = FlowControLog.builder()
                .id(IdUtils.uuid())
                .url(url)
                .createDate(date)
                .source(serverName)
                .desc("desc").build();
        //这里可以进行持久化
        log.info("接口调用信息{}",controLog);
    }
}
