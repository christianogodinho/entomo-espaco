//package com.entomo.demo.configuration;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class OpenApiConfig {
//
//    private static final String TENANT_HEADER = "X-Tenant";
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .components(
//                        new Components()
//                                .addSecuritySchemes(
//                                        TENANT_HEADER,
//                                        new SecurityScheme()
//                                                .type(SecurityScheme.Type.APIKEY)
//                                                .in(SecurityScheme.In.HEADER)
//                                                .name(TENANT_HEADER)
//                                                .description("Tenant identifier (required for all requests)")
//                                )
//                )
//                .addSecurityItem(
//                        new SecurityRequirement().addList(TENANT_HEADER)
//                );
//    }
//}
