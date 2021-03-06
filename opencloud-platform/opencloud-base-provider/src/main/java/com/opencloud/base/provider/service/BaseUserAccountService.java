package com.opencloud.base.provider.service;

import com.opencloud.base.client.model.UserAccount;
import com.opencloud.base.client.model.UserInfo;
import com.opencloud.base.client.model.entity.BaseUserAccount;
import com.opencloud.base.client.model.entity.BaseUserAccountLogs;
import com.opencloud.common.mybatis.base.service.IBaseService;

/**
 * 系统用户登录账号管理
 * 支持多账号登陆
 *
 * @author liuyadu
 */
public interface BaseUserAccountService extends IBaseService<BaseUserAccount> {

    /**
     * 注册账户
     *
     * @param profileDto
     * @return
     */
    Long register(UserInfo profileDto);


    /**
     * 绑定账号
     *
     * @param username
     * @param avatar
     * @param authType
     * @param nickName
     * @return
     */
    BaseUserAccount registerThirdAccount(String username, String avatar, String authType, String nickName);


    /**
     * 绑定账号
     *
     * @param account
     * @param password
     * @return
     */
    BaseUserAccount register(String account, String password, String accountType,String nickName);

    /**
     * 绑定系统用户名账户
     *
     * @param userId
     * @param username
     * @param password
     * @return
     */
    BaseUserAccount registerUsernameAccount(Long userId, String username, String password);

    /**
     * 绑定email账号
     *
     * @param email
     * @param userId
     * @param password
     * @return
     */
    BaseUserAccount registerEmailAccount(Long userId, String email, String password);


    /**
     * 绑定手机账号
     *
     * @param userId
     * @param password
     * @param mobile
     * @return
     */
    BaseUserAccount registerMobileAccount(Long userId, String mobile, String password);

    /**
     * 支持密码、手机号、email登陆
     * 其他方式没有规则，无法自动识别。需要单独开发
     *
     * @param account 登陆账号
     * @return
     */
    UserAccount login(String account);

    /**
     * 支持密码、手机号、QQ、微信等第三方登录
     * 其他方式没有规则，无法自动识别。需要单独开发
     *
     * @param account 登陆账号
     * @return
     */
    UserAccount applogin(String account);

    /**
     * 重置用户密码
     *
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    void resetPassword(Long userId, String oldPassword, String newPassword);

    /**
     * 重置用户密码
     *
     * @param userId
     * @param password
     */
    void resetPassword(Long userId, String password);

    /**
     * 添加登录日志
     *
     * @param log
     */
    void addLoginLog(BaseUserAccountLogs log);

    /**
     * 检查账号是否存在
     *
     * @param userId
     * @param account
     * @param accountType
     * @return
     */
    Boolean isExist(Long userId, String account, String accountType);

    /**
     * 检查账号是否存在
     *
     * @param account
     * @param accountType
     * @return
     */
    Boolean isExist(String account, String accountType);

    /**
     * 解绑email账号
     *
     * @param email
     * @param userId
     * @return
     */
    void removeEmailAccount(Long userId, String email);

    /**
     * 解绑手机账号
     *
     * @param userId
     * @param mobile
     * @return
     */
    void removeMobileAccount(Long userId, String mobile);


}
