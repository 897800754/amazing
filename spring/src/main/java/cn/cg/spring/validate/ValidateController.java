package cn.cg.spring.validate;

import cn.cg.spring.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author: cg1
 * @date: 2022-09-24 23:33
 **/
@RestController
@AllArgsConstructor
@Valid
public class ValidateController {

    private final ObjectMapper objectMapper;

    private final ValidateService validateService;

    @PostMapping("/validate")
    @SneakyThrows
    public void validate1(@RequestBody @Valid Student student) {
        System.out.println(objectMapper.writeValueAsString(student));
    }

    @PostMapping("/validate/1")
    @SneakyThrows
    public void validate2(@RequestBody Student student) {
        validateService.validate1(student);
        System.out.println(objectMapper.writeValueAsString(student));
    }

    private final Validator validator;

    @PostMapping("/validate/util")
    @SneakyThrows
    public void validateUtil(@RequestBody Student student) {
        Set<ConstraintViolation<Student>> validate = validator.validate(student, Student.Update.class);

        System.out.println(validate);
    }

    @PostMapping("/validate/Validation")
    @SneakyThrows
    public void validateValidation(@RequestBody Student student) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Student>> validate = validator.validate(student, Student.Update.class);
        System.out.println(validate);
    }


    @PostMapping("/validate/group/create")
    @SneakyThrows
    public void validateGroupCreate(@RequestBody @Validated(Student.Create.class) Student student) {
        validateService.validate1(student);
    }


    @PostMapping("/validate/group/update")
    @SneakyThrows
    public void validateGroupUpdate(@RequestBody @Validated(Student.Update.class) Student student) {
        validateService.validate1(student);
    }


}
