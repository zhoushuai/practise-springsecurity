package com.tofu.practise.springsecurity01.security.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * successForwardUrl转向url必须支持post请求。<br/>
     * 当同时配置了successForwardUrl和successHandler时successHandler生效
     *
     * @param http http安全配置
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin()
                .successForwardUrl("/index");

//                .successHandler((request, response, authentication) -> {
//      因为开启cfrf安全认证，响应时需要设置cfrf否则无法正常返回
//                    request.getRequestDispatcher("/home").forward(request, response);
//                });

    }
}
