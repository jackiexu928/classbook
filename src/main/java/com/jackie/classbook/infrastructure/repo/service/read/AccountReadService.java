package com.jackie.classbook.infrastructure.repo.service.read;

import com.jackie.classbook.dto.request.TestReqDTO;
import com.jackie.classbook.process.Context;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/30
 */
public interface AccountReadService {
    Context<TestReqDTO, Long> getLong(TestReqDTO param);
}
