package cn.cg.springsecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 配置需要放过的资源
//                .antMatchers("/index.html", "/css/**", "/img/**")
                .antMatchers("/css/**", "/img/**", "/fail.html")
                //以上url全部放行,不需要认证
                .permitAll()
                //以下url都需要认证
                .antMatchers("/**")
                .hasAnyRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                // 配置登录表单相关的信息
                .formLogin()
                // 指定自定义的登录页面
                .loginPage("/login.html")
                //登录逻辑
                .loginProcessingUrl("/login")
                //登录失败后跳转的Url,此处为Post
                //    .failureForwardUrl("/fail")
                //登录成功后跳转的Url,此处为post
                //  .successForwardUrl("/home")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        Map<String, String> map = new HashMap<>();
                        map.put("code", "200");
                        map.put("msg", "登录成功");
                        response.setStatus(HttpStatus.OK.value());
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(objectMapper.writeValueAsString(map));
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        Map<String, String> map = new HashMap<>();
                        map.put("code", "500");
                        map.put("msg", "登录失败");
                        response.setStatus(HttpStatus.OK.value());
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write(objectMapper.writeValueAsString(map));
                    }
                })
                .permitAll()
                .and()

                //添加filter
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                //记住我
                .rememberMe()
                //token 持久化仓库,默认存储在内存中
                .tokenRepository(persistentTokenRepository)
                .and().csrf().disable()


        ;

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/swagger-resources/configuration/security",
                "/swagger-ui.html"
        );
    }


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("zhang3")
//                .password("{noop}123")
//                .roles("USER");
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }


    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }


    public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

        @Value("${jwt.header:abc}")
        private String token_header;

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//            String auth_token = request.getHeader(this.token_header);
//            final String auth_token_start = "Bearer ";
//            if (StringUtils.isNotEmpty(auth_token) && auth_token.startsWith(auth_token_start)) {
//                auth_token = auth_token.substring(auth_token_start.length());
//            } else {
//                // 不按规范,不允许通过验证
//                auth_token = null;
//            }
//
//            String username = JwtUtils.getUsernameFromToken(auth_token);
//
//            logger.info(String.format("Checking authentication for user %s.", username));
//
//            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                User user = jwtUtils.getUserFromToken(auth_token);
//                if (jwtUtils.validateToken(auth_token, user)) {
//                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    logger.info(String.format("Authenticated user %s, setting security context", username));
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
            chain.doFilter(request, response);
        }
    }


    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("12345");
        System.out.println("encode---->" + encode);
        boolean matches = bCryptPasswordEncoder.matches("12345", encode);
        System.out.println(matches);
    }


}
