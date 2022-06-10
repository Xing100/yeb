package com.xxxx.server.config.security.component;

//45

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 权限控制
 * 判断用户角色
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        //获取当前所具有角色权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        //System.out.println("访问资源所需的角色列表:"+configAttributes);
        //System.out.println("当前所具有的角色列表:"+authentication.getAuthorities());

        //遍历可访问资源的角色列表
        for (ConfigAttribute configAttribute : configAttributes) {
            //当前url所需角色
            String needRole = configAttribute.getAttribute();
            //判断角色是否登录即可访问的角色，此角色在CustomeFilter
            if("ROLE_LOGIN".equals(needRole)){
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录!");

                }else {
                    return;
                }
            }
            //判断所具有的角色权限是否在可访问资源的角色权限列表中
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(needRole)) {
                    return;
                }

            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
