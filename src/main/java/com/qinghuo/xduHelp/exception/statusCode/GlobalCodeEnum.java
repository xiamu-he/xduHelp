package com.qinghuo.xduHelp.exception.statusCode;

/**
 * @author ：liuzipan
 * @date ：Created in 2019/11/2 20:46
 * @description：全局错误码
 * @modified By：
 */
public enum GlobalCodeEnum {

    //通用异常类
    HTTP_OK(200, "请求成功"),
    HTTP_NOT_AUTHORIZED(401, "请求要求身份验证"),
    HTTP_FORBIDDEN(403, "服务器拒绝请求"),
    HTTP_NOT_FOUND(404, "服务器找不到请求的资源"),
    HTTP_REQUEST_TIMEOUT(408, "服务器等候请求时发生超时"),
    SYSTEM_ERROR(500, "服务器内部错误"),
    SERVICE_NOT_AVAILABLE(503, "服务器目前无法使用"),

    //用户异常类 10XX
    USER_HAS_EXIST(1000,"用户已存在"),
    USER_NOT_LOGIN(1001, "用户未登录"),
    USER_NOT_EXIST(1002, "用户不存在"),
    USER_VERIFY_FAILURE(1003, "用户认证失败"),
    USER_SESSION_TIME_OUT(1004, "会话超时"),
    TOKEN_IS_INVALID(1005, "TOKEN过期"),
    TOKEN_CANNOT_RESOLVE(1007, "无法解析的TOKEN"),
    CODE_NOT_VALID(1008,"CODE无效"),
    USER_PASSWORD_ERROR(1009,"密码错误"),
    USER_LOGIN_FAIL(1010,"用户登录失败"),
    USER_HAS_NOT_AUTHORIZATION(1014, "没有权限操作"),
    USER_SCORE_LOW(1015, "用户分数不足"),
    USER_NOT_CERTIFIED(1016, "用户未认证"),
    USER_DAILY_SCORE_NOT_EXIST(1017, "用户每日分数不存在"),
    INSERT_FAIL(1018,"插入失败"),
    UPDATE_FAIL(1019,"修改失败"),
    DALETE_FAIL(1020,"删除失败"),


    //文件异常类 20XX
    FILE_NOT_EXIST(2000,"文件不存在"),
    FILE_NAME_EMPTY(2001, "文件名为空"),


    //普通求助异常类 30XX  --待完善

    //有偿求助异常类 31XX  --待完善

    //消息异常类 60XX    --待完善


    // 常见的服务端运行时异常90xx
    NULL_POINTER_EXCEPTION      (9001,"空指针异常"),
    CLASS_CAST_EXCEPTION        (9002,"类型转换异常"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION   (9003,"数组越界"),
    ARRAY_STORE_EXCEPTION       (9004,"数组存储异常"),
    PARAMETER_ERROR(9005,"请求参数异常"),


    // 数据库异常 91xx
    DUPLICATE_KEY_EXCEPTION      (9101, "数据库插入失败:数据已存在"),
    QUERY_EXCEPTION             (9102,"数据库执行失败:sql异常"),

    // Servlet异常 92XX
    BIND_EXCEPTION               (9201, "服务端口号被占用"),
    CONVERSION_NOT_SUPPORT_EXCEPTION (9202, "对象转换异常"),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE_EXCEPTION (9203, "客户端请求期望响应的媒体类型与服务器响应的不一致"),
    HTTP_MEDIA_TYPE_NOT_SUPPORT_EXCEPTION    (9204, "客户端请求类型不支持"),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION   (9205, "客户端请求类型不匹配"),
    HTTP_MESSAGE_NOT_WRITABLE_EXCEPTION   (9206, "返回数据类型写入异常"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION (9207, "客户端使用的请求方法不被该接口支持"),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION       (9208, "方法参数不合法"),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION (9209, "请求参数缺失"),
    MISSING_SERVLET_REQUEST_PART_EXCEPTION     (9210, "上传文件参数异常"),
    NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION  (9211, "服务器找不到对应的请求资源"),
    TYPE_MISMATCH_EXCEPTION                     (9212, "bean类型不匹配异常"),

    //其他异常
    OTHER_EXCEPTION             (9999,"未定义的其他异常");


    private Integer code;
    private String msg;

    private GlobalCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
