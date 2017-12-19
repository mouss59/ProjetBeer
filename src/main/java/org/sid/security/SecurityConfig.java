package org.sid.security;

import org.sid.services.BarServiceInterface;
import org.sid.services.PersonneInterface;
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

    @Autowired
    private PersonneInterface personneMetier;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        //personneMetier.chercherPersonneLoginPass();
       auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
       auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");



    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/");
        http.authorizeRequests().antMatchers("/operationClient","/chercherBarNomP","/chercherBarBeerNom",
                "/chercherBarBeerType" , "/operationbarPrefere","/chercherBarNom", "/ajouterBarPrefere", "/operationBeerPrefere" ,
                "/chercherBeerNom" , "/ajouterBeerPerson"
                ).hasRole("USER");


        http.authorizeRequests().antMatchers("/operationBar",
                "/chercherBierreNom",
                "/chercherBierreType",
                "/ajouterBeerBar",
                "/chercherBarNomBar",
                "/ajouterBeer",
                "/operationClientFidel",
                "/clientsFidels").hasRole("ADMIN");

       // http.exceptionHandling().accessDeniedPage("/403");
    }


}
