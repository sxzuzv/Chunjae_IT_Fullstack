package kr.co.chunjae.security;

import lombok.extern.log4j.Log4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 로그인 이후, 특정 동작을 제어하고 어떤 경로에서 로그인을 시도하든 특정 사이트로 무조건 이동할 수 있도록 핸들러를 작성한다.
* 'ROLE_ADMIN' 권한을 가졌을 시, 로그인 이후 곧바로 '/sample/admin' 경로로 이동하게 된다.
 */

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        log.warn("Login Success");

        List<String> roleNames = new ArrayList<>();

        auth.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());
        });

        log.warn("ROLE NAMES: " + roleNames);

        if (roleNames.contains("ROLE_ADMIN")) {
            response.sendRedirect("/sample/admin");
            return;
        }

        if (roleNames.contains("ROLE_MEMBER")) {
            response.sendRedirect("/sample/member");
            return;
        }

        response.sendRedirect("/");
    }
}
