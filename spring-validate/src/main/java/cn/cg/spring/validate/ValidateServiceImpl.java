package cn.cg.spring.validate;

import cn.cg.spring.model.Student;
import org.springframework.stereotype.Service;

/**
 * @author: cg1
 * @date: 2022-09-25 01:49
 **/
@Service
public class ValidateServiceImpl implements ValidateService {
    @Override
    public void validate1(Student student) {
        System.out.println("service::" + student);
    }
}
