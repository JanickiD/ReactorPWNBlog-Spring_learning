package pl.pwn.reaktor.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecutirtyConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth
			.jdbcAuthentication()
			.usersByUsernameQuery("SELECT email, pass, active FROM user where email=?")
			.authoritiesByUsernameQuery("SELECT u.email, r.role FROM user u inner join role r on r.id = u.role where u.email=?")
			.dataSource(dataSource)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/admin/").hasAuthority("Admin")
			.antMatchers("/post/add", "/post/edit").hasAnyAuthority("User", "Admin")
			.anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/")
			.usernameParameter("email")
			.passwordParameter("pass")
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
}
