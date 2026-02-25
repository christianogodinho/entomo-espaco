package com.entomo.demo.security;


import com.entomo.demo.util.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


/**
 * Classe de configuração de segurança da aplicação utilizando Spring Security.
 *
 * <p>Essa classe define as regras de autenticação e autorização, além de configurar o CORS
 * (Cross-Origin Resource Sharing) para permitir requisições da aplicação cliente, como uma aplicação React Native.</p>
 *
 * <p>Configurações principais:
 * <ul>
 *   <li>Desabilita a proteção CSRF (Cross-Site Request Forgery), útil para APIs REST.</li>
 *   <li>Configura o CORS para permitir chamadas de outras origens.</li>
 *   <li>Define rotas públicas específicas (ex: Swagger e endpoint "/v1/medidas/...").</li>
 *   <li>Permite requisições HTTP OPTIONS sem autenticação, necessárias para o preflight do CORS.</li>
 *   <li>Requer autenticação para todas as outras rotas não especificadas.</li>
 *   <li>Habilita autenticação por formulário e HTTP Basic.</li>
 * </ul>
 * </p>
 *
 * <p>Esta configuração é ideal para ambientes de desenvolvimento e pode ser ajustada para produção com medidas de segurança mais restritas.</p>
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    protected DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disabling CSRF protection
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // INTEGRAÇÃO CORS AQUI!
                .authorizeHttpRequests(auth -> auth
                                // 1. PERMITE REQUISIÇÕES OPTIONS PARA QUALQUER CAMINHO (PREFLIGHT CORS)
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                // 2. PERMITE SEU ENDPOINT ESPECÍFICO SEM AUTENTICAÇÃO
                                // Certifique-se de que este é o caminho correto que sua aplicação React Native está chamando.
                                .requestMatchers(Constants.API + "/**").permitAll()
                                // 3. Adicione os caminhos do AUTH_WHITELIST para permitir Swagger, etc.
                                .requestMatchers(AUTH_WHITELIST).permitAll()
                                // Se você quiser permitir TODOS os endpoints SEM autenticação para testes, use a linha abaixo (com cautela):
                                //.requestMatchers("/**").permitAll()
                                // Se você quiser permitir alguns IPs SEM autenticação para testes, use a linha abaixo (com cautela):
                                .requestMatchers("/**").access(new WebExpressionAuthorizationManager("hasIpAddress('192.168.0.0/24')"))
                        // Caso contrário, todas as outras requisições exigem autenticação:
                        //.anyRequest().authenticated()
                )
                //.formLogin(withDefaults()) // Se você usa formulário de login
                //.httpBasic(withDefaults()) // Se você usa autenticação HTTP Basic
                .build();
    }

    // Bean para configurar o CORS, agora integrado com Spring Security
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Adicione as origens que sua aplicação React Native usa
        configuration.setAllowedOrigins(Arrays.asList(CORS_ALLOWED_ORIGINS));
        configuration.setAllowedMethods(Arrays.asList(CORS_ALLOWED_METHODS));
        configuration.setAllowedHeaders(Arrays.asList(CORS_ALLOWED_HEADERS)); // Permite todos os cabeçalhos
        configuration.setAllowCredentials(false); // Mantenha isso se você envia cookies/headers de auth
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Aplica a todos os caminhos
        return source;
    }

    private static final String[] AUTH_WHITELIST = {
            // for Swagger UI v2
            "/v2/api-docs",
            "/swagger-ui.html",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/webjars/**",

            // for Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/actuator/health/**"
    };

    private static final String[] CORS_ALLOWED_ORIGINS= {
           "http://localhost:5174"
    };

    private static final String[] CORS_ALLOWED_METHODS = {
            "GET",
            "POST",
            "PUT",
            "DELETE",
            "OPTIONS"
    };

    private static final String[] CORS_ALLOWED_HEADERS = {
            "*"
    };
}
