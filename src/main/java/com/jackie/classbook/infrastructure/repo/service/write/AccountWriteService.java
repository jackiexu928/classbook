package com.jackie.classbook.infrastructure.repo.service.write;

import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public interface AccountWriteService {
    Context<LoginReqDTO,AccountLoginRespDTO> login(LoginReqDTO param);
}
