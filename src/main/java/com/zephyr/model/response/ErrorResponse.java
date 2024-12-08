package com.zephyr.model.response;

import java.io.Serial;
import java.io.Serializable;

// 通用错误响应实体类
public class ErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 错误码，用于唯一标识不同类型的错误，方便前端根据错误码进行针对性处理
    private String errorCode;

    // 错误消息，用于描述具体的错误详情，方便用户理解出现了什么问题
    private String errorMessage;

    // 时间戳，记录错误发生的时间，可用于日志记录、排查问题时参考时间顺序等
    private long timestamp;

    // 可用于指定导致错误的具体 URL（比如在 Web 应用中，是哪个接口请求出现了错误）
    private String requestUrl;

    // 可选，用于提供更多关于错误的详细信息，比如在验证失败时，具体是哪个字段不符合要求等，以 JSON 格式存储更详细的错误内容
    private Object details;

    public ErrorResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public ErrorResponse(String errorCode, String errorMessage, String requestUrl) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.requestUrl = requestUrl;
        this.timestamp = System.currentTimeMillis();
    }

    public ErrorResponse(String errorCode, String errorMessage, String requestUrl, Object details) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.requestUrl = requestUrl;
        this.details = details;
        this.timestamp = System.currentTimeMillis();
    }

    // Getter 和 Setter 方法

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }
}