package com.anhua.security.MySecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.Encoder;

//开启security
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {
    //    授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
//                页面访问权限的设置
                .antMatchers("/login").permitAll()
                .antMatchers("/111").hasRole("vip1")
                .antMatchers("/112").hasRole("vip1")
                .antMatchers("/222").hasRole("vip2")
                .antMatchers("/221").hasRole("vip2");
//        没有授权默认会走到登录页面
        http.formLogin();
//        开启注销功能
//logout后退出到login页面
        http.logout().logoutSuccessUrl("/login");
//        记住我
        http.rememberMe();
//      定制登录月,会跑到自己定制的login页面
//        不设置自己的页面会走默认security自带登录页
//        http.formLogin().loginPage("/login");

    }

    //    认证
//    密码要进行编码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
//                用户授权
    withUser("anhua").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip3")
    .and()
    .withUser("anhua2").password(new BCryptPasswordEncoder().encode("123")).roles("vip2", "vip1");
    }

}
