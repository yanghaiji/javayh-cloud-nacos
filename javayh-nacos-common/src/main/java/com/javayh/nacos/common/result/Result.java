package com.javayh.nacos.common.result;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;
    /*消息*/
    private static String query = "query.success";
    private static String insert = "insert.success";
    private static String update = "update.success";
    private static String delete = "delete.success";
    private static String failed = "failed";

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 查询成功
     *
     * @param data
     * @return
     */
    public static <T> Result javaYhQuerySuccess(T data) {
        return new Result(ResultCode.SUCCESS.getCode(), query, data);
    }

    /**
     * 新增成功
     *
     * @param data
     * @return
     */
    public static <T> Result insertSuccess(T data) {
        return new Result(ResultCode.SUCCESS.getCode(), insert, data);
    }


    /**
     * 更新成功
     *
     * @param data
     * @return
     */
    public static <T> Result javaYhUpdateSuccess(T data) {
        return new Result(ResultCode.SUCCESS.getCode(), update, data);
    }

    /**
     * 删除成功
     *
     * @param data
     * @return
     */
    public static <T> Result javaYhDeleteSuccess(T data) {
        return new Result(ResultCode.SUCCESS.getCode(), delete, data);
    }

    /**
     * 处理异常
     *
     * @param data
     * @return
     */
    public static <T> Result javaYhResultFailed(T data) {
        return new Result(ResultCode.FAILED.getCode(), failed, data);
    }
}
