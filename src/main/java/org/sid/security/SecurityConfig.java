package org.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
       //auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");


       /* on utilise repository
       auth.jdbcAuthentication().dataSource(dataSource)
               .usersByUsernameQuery("select login as principal, password as credentials from personne where login=?")
               .authoritiesByUsernameQuery("select login as principal, status as role from personne where login=?")
               .rolePrefix("ROLE_");

*/
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin();
        //http.authorizeRequests().antMatchers("/login","/operationClient").hasRole("USER");
       // http.authorizeRequests().antMatchers("/login","/operationBar").hasRole("ADMIN");

       // http.exceptionHandling().accessDeniedPage("/403");
    }


}
