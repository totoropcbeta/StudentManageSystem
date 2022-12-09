package com.totoropcbeta.studentmanagesystem.component;


import com.totoropcbeta.studentmanagesystem.enums.ApiStatus;
import com.totoropcbeta.studentmanagesystem.utils.JacksonUtil;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未登录异常处理类
 * 当用户尝试访问需要权限才能的REST资源而不提供Token或者Token错误或者过期时,
 * 将调用此方法发送401响应以及错误信息
 */
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().println(JacksonUtil.toJsonString(ResultVo.fail(ApiStatus.NOT_PERMISSION.getMsg())));
        response.getWriter().flush();
    }
}
