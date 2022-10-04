package cn.cg.spring.validate;

import cn.cg.spring.model.Student;
import org.springframework.validation.annotation.Validated;

/**
 * @author: cg1
 * @date: 2022-09-25 01:49
 **/
@Validated
public interface ValidateService {

    void validate1(@Validated(Student.Update.class) Student student);
}
