package cn.cg.mybatisflex.service;

import cn.cg.mybatisflex.entity.Account;
import cn.cg.mybatisflex.mapper.AccountMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author: cg
 * @date: 2023-08-02 16:37
 **/
@Component
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
