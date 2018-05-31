package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.enumtype.ClassbookCodeEnum;
import com.jackie.classbook.dto.BaseReqDTO;
import com.jackie.classbook.exception.ClassbookException;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public class LoginReqDTO extends BaseReqDTO {
    private String account;     //邮箱或手机号
    private String password;    //密码

    @Override
    public void validation() {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
