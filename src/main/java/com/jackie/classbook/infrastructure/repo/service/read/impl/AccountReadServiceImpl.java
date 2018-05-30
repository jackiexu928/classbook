package com.jackie.classbook.infrastructure.repo.service.read.impl;

import com.jackie.classbook.dto.request.TestReqDTO;
import com.jackie.classbook.infrastructure.repo.service.read.AccountReadService;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/30
 */
@Service
public class AccountReadServiceImpl extends AbstractQueryService implements AccountReadService {
    @Override
    public Context<TestReqDTO, Long> getLong(TestReqDTO param) {
        Long l = 0L;
        if (param.getInteger() == 1){
            l = 2L;
        }
        Context<TestReqDTO, Long> context = new Context<>();
        context.setResult(l);
        return context;
    }
}
