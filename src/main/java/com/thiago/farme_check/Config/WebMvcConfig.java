package com.thiago.farme_check.Config;

import com.thiago.farme_check.Interceptor.AutorizacaoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private AutorizacaoInterceptor autorizacaoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(autorizacaoInterceptor)
                // 1. Aplica o interceptor em absolutamente TODAS as URLs do sistema
                .addPathPatterns("/**")

                // 2. Abre exceções para as rotas que QUALQUER pessoa pode aceder sem login
                .excludePathPatterns(
                        "/",                    // Tela de login inicial
                        "/efetuar-login",       // Ação de processar o login
                        "/cadastro",            // Tela de criar nova conta de usuário
                        "/efetuar-cadastro",    // Ação de salvar o usuário no banco
                        "/h2-console/**",       // O banco de dados H2 para você mexer livremente
                        "/css/**", "/js/**"     // Arquivos de estilização (Bootstrap, etc), se houver
                );
    }
}
