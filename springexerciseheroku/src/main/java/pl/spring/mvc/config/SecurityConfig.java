package pl.spring.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.passwordEncoder(new BCryptPasswordEncoder())
		.withUser("admin")
		.password(new BCryptPasswordEncoder().encode("admin"))
		.roles("ADMIN")
		.and()
		.withUser("user")
		.password(new BCryptPasswordEncoder().encode("user"))
		.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.mvcMatchers("/taskForm")
		.hasRole("ADMIN")
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error")
		.and()
		.logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}

	
}
