package com.jason.demo.http.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: jason
 * @Date: 2020-08-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserReq {
    private String username;
    private String password;
}
