package com.gavrilov.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Override
    /**
     * Из контекста безопасноти вытаскиваем аутентификацию пользователя
     * @return вернет аутентификацию для текущего пользователя
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
