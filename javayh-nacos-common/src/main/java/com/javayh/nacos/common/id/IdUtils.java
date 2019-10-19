package com.javayh.nacos.common.id;

import java.util.UUID;

/**
 * @author Dylan Yang
 * @Description: id
 * @ProjectName javayh-cloud-nacos
 * @date 2019-10-19 16:07
 */
public class IdUtils {
    /**
     * uuid
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }

    /**
     * uuidIntt
     * @return
     */
    public static int uuidInt(){
        return Math.abs(UUID.randomUUID().toString().hashCode());
    }
}
