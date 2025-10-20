package poly.edu.interceptor;

import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import poly.edu.entity.Account;

import java.util.Date;

@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Account user = (Account) request.getSession().getAttribute("user");
        if (user != null) {
            System.out.println(request.getRequestURI() + ", " + new Date() + ", " + user.getFullname());
        }
        return true;
    }
}
