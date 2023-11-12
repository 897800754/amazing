package quickstart;

import lombok.Data;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author: cg1
 * @date: 2022-09-24 15:22
 **/
public class ElementMatcherTest1 {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("123");


        boolean matches = ElementMatchers.any().and(new ElementMatcher.Junction.AbstractBase<UserInfo>() {
            @Override
            public boolean matches(UserInfo target) {
                if (userInfo.getId() == 2) {
                    return true;
                }
                return false;
            }
        }).matches(userInfo);
        System.out.println("==========" + matches);


        boolean matches1 = ElementMatchers.any().and(new ElementMatcher.Junction.AbstractBase<UserInfo>() {
            @Override
            public boolean matches(UserInfo target) {
                if (userInfo.getId() == 2) {
                    return true;
                }
                return false;
            }
        }).or(new ElementMatcher.Junction.AbstractBase<UserInfo>() {
            @Override
            public boolean matches(UserInfo target) {
                if (userInfo.getId() == 1) {
                    return true;
                }
                return false;
            }
        }).matches(userInfo);
        System.out.println("==========" + matches1);


    }

    @Data
    public static class UserInfo {
        private Integer id;
        private String name;

    }


}
