package com.totoropcbeta.studentmanagesystem.provider;

import com.totoropcbeta.studentmanagesystem.entity.StudentAccount;
import com.totoropcbeta.studentmanagesystem.entity.UserDetail;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class AuthProvider {
    public static UserDetail getUserDetail() {
        return (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static StudentAccount getUserInfo() {
        return ((UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getStudentAccount();
    }

    public static String getLoginAccount() {
        return ((UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public static Integer getUserId() {
        return ((UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
    }

    public static List<String> getAuthorities() {
        return ((UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getRoles();
    }
}
