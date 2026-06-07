package com.thiago.farme_check.Interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AutorizacaoInterceptor implements HandlerInterceptor { // "implements" corrigido para minúsculo

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("usuarioLogado") != null) {
            return true;
        }

        response.sendRedirect("/");
        return false;
    }

}
