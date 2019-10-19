package com.javayh.nacos.common.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Dylan Yang
 * @Description:
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 16:05
 */
@Data
@Builder
public class SysNacos {
    private String id;
    private String name;
    private String pwd;
}
