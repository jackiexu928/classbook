package com.jackie.classbook;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.request.TestReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.infrastructure.repo.service.read.AccountReadService;
import com.jackie.classbook.process.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceReadTest {
    @Autowired
    AccountReadService accountReadService;

    @Test
    public void testGetLong(){
        TestReqDTO reqDTO = new TestReqDTO();
        reqDTO.setInteger(1);
        Context<TestReqDTO, Long> context = accountReadService.getLong(reqDTO);
        System.out.println(JSON.toJSON(context));
    }
}
