package com.totoropcbeta.studentmanagesystem.component;


import com.totoropcbeta.studentmanagesystem.enums.ApiStatus;
import com.totoropcbeta.studentmanagesystem.utils.JacksonUtil;
import com.totoropcbeta.studentmanagesystem.vo.ResultVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限不足异常处理类
 * 当用户尝试访问需要权限才能的REST资源而权限不足的时候,
 * 将调用此方法发送403响应以及错误信息
 */
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException e) throws IOException {

        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().println(JacksonUtil.toJsonString(ResultVo.fail(ApiStatus.NOT_PERMISSION.getMsg())));
        response.getWriter().flush();
    }
}
