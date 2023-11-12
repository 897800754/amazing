package cn.cg.springsecurity;

import cn.cg.springsecurity.domain.Account;
import cn.cg.springsecurity.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cg
 * @date: 2023-08-02 19:37
 **/
@Service
public class AccountServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Account account = accountRepository.getUserByName(username);

        System.out.println("---------->" + account);
        if (account != null) {
            // 账号对应的权限
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            // 说明账号存在 {noop} 非加密的使用
            UserDetails details = new User(account.getUserName(), account.getPassword(), authorities);
            return details;
        }
        throw new UsernameNotFoundException("账号不存在...");

    }
}
