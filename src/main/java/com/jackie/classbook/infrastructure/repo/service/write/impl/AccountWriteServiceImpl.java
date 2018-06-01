package com.jackie.classbook.infrastructure.repo.service.write.impl;

import com.jackie.classbook.common.enumtype.ClassbookCodeEnum;
import com.jackie.classbook.domain.dbdo.AccountDO;
import com.jackie.classbook.domain.module.AccountDOFactory;
import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.dto.response.AccountRespDTO;
import com.jackie.classbook.exception.ClassbookException;
import com.jackie.classbook.infrastructure.repo.service.write.AccountWriteService;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.util.UuidUtil;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
@Service
public class AccountWriteServiceImpl extends AbstractService implements AccountWriteService {
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
}
