package com.jackie.classbook.domain.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.domain.dbdo.AccountDO;
import com.jackie.classbook.dto.response.AccountRespDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:AccountDO转换类
 *
 * @author xujj
 * @date 2018/5/31
 */
public class AccountDOFactory {

    public static AccountRespDTO converDOToDTO(AccountDO accountDO){
        if (accountDO == null){
            return null;
        }
        String str = JSON.toJSONString(accountDO);
        AccountRespDTO accountRespDTO = JSON.parseObject(str, AccountRespDTO.class);
        return accountRespDTO;
    }

    public static List<AccountRespDTO> convertDOToDTO(List<AccountDO> list){
        if (list == null){
            return null;
        }
        List<AccountRespDTO> resultList = new ArrayList<>();
        for (AccountDO accountDO : list){
            resultList.add(converDOToDTO(accountDO));
        }
        return resultList;
    }

}
