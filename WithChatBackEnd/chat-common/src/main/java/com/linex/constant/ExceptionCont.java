package com.linex.constant;

/**
 * @author linexsong
 */
public class ExceptionCont {
    public static final String OSS_INIT_ERROR = "对象存储初始化错误";
    public static final String OSS_BUCKET_NOT_EXISTS = "目标 Bucket 不存在";
    public static final String OSS_UPLOAD_ERROR = "文件上传失败";
    public static final String OSS_GET_ERROR = "文件获取失败";

    // 用户管理服务异常

    public static final String USER_PWD_TO_SHA_ERR = "用户密码加密失败";
    public static final String USER_SIGNUP_ERROR = "用户注册失败";
    public static final String USER_PWD_FORMAT_ERR = "用户密码格式有误";
    public static final String USER_VERIFICATION_ERR = "用户账号或密码错误";
    public static final String MSG_NOT_PERMITTED = "无法向该用户发送信息";

    // 管理员服务异常

    public static final String ADMIN_VERIFY_ERR = "管理员账号或密码错误";
}
