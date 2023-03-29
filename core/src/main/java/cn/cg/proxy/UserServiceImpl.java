package cn.cg.proxy;

/**
 * @author Administrator
 * @title: UserService
 * @projectName workspace_idea
 * @description: TODO
 * @date 2019/7/71:11
 */
public class UserServiceImpl implements UserService {
    @Override
    public void get() {
        System.out.println("获取用户");
    }

    @Override
    public void add(String string) {
        System.out.println("添加用户" + string);
    }
}
