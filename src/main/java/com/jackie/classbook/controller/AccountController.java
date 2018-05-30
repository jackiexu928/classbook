package com.jackie.classbook.controller;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.request.TestReqDTO;
import com.jackie.classbook.infrastructure.repo.service.read.AccountReadService;
import com.jackie.classbook.infrastructure.repo.service.read.impl.AccountReadServiceImpl;
import com.jackie.classbook.process.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/29
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
    @Autowired
    private AccountReadService accountReadService;

    @RequestMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public String login(){
        TestReqDTO reqDTO = new TestReqDTO();
        reqDTO.setInteger(1);
        return toJSON(accountReadService.getLong(reqDTO));
    }
}
