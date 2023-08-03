package com.master.modular.business.base.response;

/**
 * @author wangyue
 * @date 2023/8/1
 */
public class ResponseResult {

    /**
     * 请求是否成功
     */
    private Boolean success;

    /**
     * 响应状态码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应对象
     */
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(Boolean success, String code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
