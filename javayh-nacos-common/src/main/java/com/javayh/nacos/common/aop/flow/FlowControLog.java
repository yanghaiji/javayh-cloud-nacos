package com.javayh.nacos.common.aop.flow;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Dylan Yang
 * @Description: 流水日志
 * @ProjectName javayh-cloud-nacos
 * @date 2020-01-06 21:01
 */
@Builder
@Data
public class FlowControLog implements Serializable {
    /*id*/
    private String id;
    /*url*/
    private String url;
    /*调用时间*/
    private String createDate;
    /*来源*/
    private String source;
    /*预留*/
    private String desc;

}
