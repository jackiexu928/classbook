package com.jackie.classbook.controller;

import com.jackie.classbook.process.Context;
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

    @RequestMapping("/login")
    public String login(){
        Context<Integer, Long> context = new Context<>();
        context.setSuccess(true);
        context.setResult(2L);
        return toJSON(context);
    }
}
