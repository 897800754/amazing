package cn.cg.trx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: cg
 * @date: 2023-04-05 17:36
 **/
@Service
public class Uservice {
    @Autowired
    TransactionTemplate transactionTemplate;


    public void hello() {
//        transactionTemplate.
    }
}
