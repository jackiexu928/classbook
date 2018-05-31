package com.jackie.classbook.infrastructure.repo.service.read.impl;

import com.jackie.classbook.common.enumtype.ClassbookCodeEnum;
import com.jackie.classbook.domain.dbdo.AccountDO;
import com.jackie.classbook.domain.module.AccountDOFactory;
import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.request.TestReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.dto.response.AccountRespDTO;
import com.jackie.classbook.exception.ClassbookException;
import com.jackie.classbook.infrastructure.repo.service.read.AccountReadService;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.util.TrackHolder;
import com.jackie.classbook.util.UuidUtil;
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

    @Override
    public Context<LoginReqDTO, AccountLoginRespDTO> login(LoginReqDTO param) {
        AccountDO accountDO = new AccountDO();
        if (param.getAccount().equals("18767159385") && param.getPassword().equals("123456")){
            accountDO.setId(1L);
            accountDO.setName("jackie");
        }else {
            throw new ClassbookException(ClassbookCodeEnum.ACCOUNT_OR_PASSWORD);
        }
        AccountLoginRespDTO respDTO = new AccountLoginRespDTO();
        AccountRespDTO accountRespDTO = AccountDOFactory.converDOToDTO(accountDO);
        accountRespDTO.setToken(UuidUtil.getUuidNoSplit());
        respDTO.setAccountRespDTO(accountRespDTO);
        Context<LoginReqDTO, AccountLoginRespDTO> context = new Context<>();
        context.setResult(respDTO);
        return context;
    }

    @Override
    public Context<TestReqDTO, AccountLoginRespDTO> testTrackHolder(TestReqDTO param) {
        AccountLoginRespDTO accountLoginRespDTO = TrackHolder.getTracker().getAccountLoginRespDTO();
        Context<TestReqDTO, AccountLoginRespDTO> context = new Context<>();
        context.setResult(accountLoginRespDTO);
        return context;
    }
}
