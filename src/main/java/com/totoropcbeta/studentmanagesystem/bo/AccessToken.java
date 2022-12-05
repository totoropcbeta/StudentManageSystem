package com.totoropcbeta.studentmanagesystem.bo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class AccessToken {
    private String loginAccount;
    private String accessToken;
    private Date expirationTime;
}
