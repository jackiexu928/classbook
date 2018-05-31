package com.jackie.classbook.controller;

import com.jackie.classbook.common.constant.RedisConstants;
import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.request.TestReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.infrastructure.repo.service.read.AccountReadService;
import com.jackie.classbook.process.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Singleton;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/29
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController {
    @Autowired
    private AccountReadService accountReadService;

    @RequestMapping(value = "login",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String login(LoginReqDTO reqDTO){
        Context<LoginReqDTO,AccountLoginRespDTO> context = accountReadService.login(reqDTO);
        AccountLoginRespDTO respDTO = context.getResult();
        //TODO 将登录的用户放入缓存cookie
        Cookie accountCookie=new Cookie("accountId", String.valueOf(respDTO.getAccountRespDTO().getId()));
        accountCookie.setMaxAge(RedisConstants.USER_CACHE_TIME_OUT);
        accountCookie.setPath("/");

        String token= respDTO.getAccountRespDTO().getToken();
        Cookie tokenCookie=new Cookie("token",token);
        tokenCookie.setMaxAge(RedisConstants.USER_CACHE_TIME_OUT);
        tokenCookie.setPath("/");

        return toJSON(context);
    }

    @RequestMapping(value = "test",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String test(TestReqDTO reqDTO){
        return toJSON(accountReadService.getLong(reqDTO));
    }

    @RequestMapping(value = "testTrackHolder",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String testTrackHolder(TestReqDTO reqDTO){
        return toJSON(accountReadService.testTrackHolder(reqDTO));
    }
}
