package com.sweet.core.shiro;import cn.hutool.system.UserInfo;import com.sweet.core.sweetConst;import com.sweet.core.util.StringUtil;import com.sweet.system.entity.User;import org.apache.commons.collections.functors.ConstantFactory;import org.apache.shiro.SecurityUtils;import org.apache.shiro.session.Session;import org.apache.shiro.subject.PrincipalCollection;import org.apache.shiro.subject.SimplePrincipalCollection;import org.apache.shiro.subject.Subject;import org.apache.shiro.util.ThreadContext;import java.util.List;public class ShiroKit {    private static final String NAMES_DELIMETER = ",";    /**     * 获取当前 Subject     *     * @return Subject     */    public static Subject getSubject() {        Subject subjects = SecurityUtils.getSubject();        ThreadContext.bind(subjects);            return SecurityUtils.getSubject();    }    /**     * 获取封装的 ShiroUser     *     * @return ShiroUser     */    public static User getUser() {        if (isGuest()) {            return null;        } else {            return (User) getSubject().getPrincipals().getPrimaryPrincipal();        }    }    /**     * 认证通过或已记住的用户。与guset搭配使用。     *     * @return 用户：true，否则 false     */    public static boolean isUser() {        return getSubject() != null && getSubject().getPrincipal() != null;    }    /**     * 验证当前用户是否为“访客”，即未认证（包含未记住）的用户。用user搭配使用     *     * @return 访客：true，否则false     */    public static boolean isGuest() {        return !isUser();    }    /**     * 已认证通过的用户。不包含已记住的用户，这是与user标签的区别所在。与notAuthenticated搭配使用     *     * @return 通过身份验证：true，否则false     */    public static boolean isAuthenticated() {        return getSubject() != null && getSubject().isAuthenticated();    }    /**     * 未认证通过用户，与authenticated标签相对应。与guest标签的区别是，该标签包含已记住用户。。     *     * @return 没有通过身份验证：true，否则false     */    public static boolean notAuthenticated() {        return !isAuthenticated();    }    /**     * 从shiro获取session     */    public static Session getSession() {        return getSubject().getSession();    }    /**     * 获取shiro指定的sessionKey     */    @SuppressWarnings("unchecked")    public static <T> T getSessionAttr(String key) {        Session session = getSession();        return session != null ? (T) session.getAttribute(key) : null;    }    /**     * 设置shiro指定的sessionKey     */    public static void setSessionAttr(String key, Object value) {        Session session = getSession();        session.setAttribute(key, value);    }    /**     * 移除shiro指定的sessionKey     */    public static void removeSessionAttr(String key) {        Session session = getSession();        if (session != null) {            session.removeAttribute(key);        }    }    /**     * 切换身份，登录后，动态更改subject的用户属性     * @param     */    public static void updateUser(User user) {        Subject subject = SecurityUtils.getSubject();        PrincipalCollection principalCollection = subject.getPrincipals();        String realmName = principalCollection.getRealmNames().iterator().next();        if(StringUtil.isEmpty(user.getAvatar())){            user.setAvatarPath(sweetConst.DEFALT_AVATAR);        }        PrincipalCollection newPrincipalCollection =                new SimplePrincipalCollection(user, realmName);        subject.runAs(newPrincipalCollection);    }    /**     * 验证当前用户是否属于该角色？,使用时与lacksRole 搭配使用     *     * @param roleName 角色名     * @return 属于该角色：true，否则false     */    public static boolean hasRole(String roleName) {        return getSubject() != null && roleName != null                && roleName.length() > 0 && getSubject().hasRole(roleName);    }    /**     * 与hasRole标签逻辑相反，当用户不属于该角色时验证通过。     *     * @param roleName 角色名     * @return 不属于该角色：true，否则false     */    public static boolean lacksRole(String roleName) {        return !hasRole(roleName);    }    /**     * 验证当前用户是否属于以下任意一个角色。     *     * @param roleNames 角色列表     * @return 属于:true,否则false     */    public static boolean hasAnyRoles(String roleNames) {        boolean hasAnyRole = false;        Subject subject = getSubject();        if (subject != null && roleNames != null && roleNames.length() > 0) {            for (String role : roleNames.split(NAMES_DELIMETER)) {                if (subject.hasRole(role.trim())) {                    hasAnyRole = true;                    break;                }            }        }        return hasAnyRole;    }    /**     * 验证当前用户是否拥有指定权限,使用时与lacksPermission 搭配使用     *     * @param permission 权限名     * @return 拥有权限：true，否则false     */    public static boolean hasPermission(String permission) {        return getSubject() != null && permission != null                && permission.length() > 0                && getSubject().isPermitted(permission);    }    /**     * 与hasPermission标签逻辑相反，当前用户没有制定权限时，验证通过。     *     * @param permission 权限名     * @return 拥有权限：true，否则false     */    public static boolean lacksPermission(String permission) {        return !hasPermission(permission);    }    /**     * 输出当前用户信息，通常为登录帐号信息。     *     * @return 当前用户信息     */    public static String principal() {        if (getSubject() != null) {            Object principal = getSubject().getPrincipal();            return principal.toString();        }        return "";    }}