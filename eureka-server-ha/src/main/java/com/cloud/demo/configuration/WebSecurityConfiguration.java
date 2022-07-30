package com.cloud.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ClassName:WebSecurityConfiguration
 * Package:com.cloud.demo.configuration
 * Description:
 *
 * @Date:2021/12/13 15:46
 * @Author:qs@1.com
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Eureka会自动配置CSRF防御机制,spring security认为post,put and delete http methods 都是有风险的,如果
     * 这些method发送过程中没有带上CSRF token,会被直接拦截并返回403 forbidden
     *
     * 因为eureka的安全认证用到了这个spring-security，新版本中如果不配置这个的话，server集群之间的通信就会被拦截掉
     * 导致启动出错，旧版本的话貌似不需要配置这个
     *
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 保持密码验证的同时禁用CSRF的防御机制
         */
        // 关闭csrf
        http.csrf().disable();
        // 支持httpBasic
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();


        /**************方案二：过滤指定路径**************/
        //这句为了访问eureka控制台和/actuator时能做安全控制
//        super.configure(http);
//        //忽略指定路径的所有请求
//        http.csrf().ignoringAntMatchers("/eureka/**");
    }
}
