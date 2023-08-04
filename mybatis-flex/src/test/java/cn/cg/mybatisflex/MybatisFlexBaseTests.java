package cn.cg.mybatisflex;

import cn.cg.mybatisflex.entity.Account;
import cn.cg.mybatisflex.mapper.AccountMapper;
import cn.cg.mybatisflex.mapper.ArticleMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Db;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.cg.mybatisflex.entity.table.AccountTableDef.ACCOUNT;
import static cn.cg.mybatisflex.entity.table.ArticleTableDef.ARTICLE;

/**
 * hello world
 */
@SpringBootTest
class MybatisFlexBaseTests {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 单表查询
     * QueryMethods.max()
     */
    @Test
    public void query() {

        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(ACCOUNT.AGE.eq(18));
        Account account = accountMapper.selectOneByQuery(queryWrapper);
        System.out.println(account);
    }

    /**
     * 关联查询
     */
    @Test
    public void assoQuery() {
        QueryWrapper where = QueryWrapper.create()
                .select(ARTICLE.ALL_COLUMNS)
                //设置别名
                .select(ACCOUNT.AGE, ACCOUNT.USER_NAME.as(ArticleDTO::getAuthorName), ACCOUNT.BIRTHDAY)
                .from(ARTICLE)
                .leftJoin(ACCOUNT).on(ARTICLE.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(ACCOUNT.ID.ge(0));
        List<ArticleDTO> articleDTOS = articleMapper.selectListByQueryAs(where, ArticleDTO.class);
        System.out.println(articleDTOS);
    }

    /**
     * 分页查询
     */
    @Test
    public void page() {
        QueryWrapper where = QueryWrapper.create()
                .select(ARTICLE.ALL_COLUMNS)
                //设置别名
                .select(ACCOUNT.AGE, ACCOUNT.USER_NAME.as(ArticleDTO::getAuthorName), ACCOUNT.BIRTHDAY)
                .from(ARTICLE)
                .leftJoin(ACCOUNT).on(ARTICLE.ACCOUNT_ID.eq(ACCOUNT.ID))
                .where(ACCOUNT.ID.ge(0));
        Page<ArticleDTO> articleDTOPage = articleMapper.paginateAs(Page.of(1, 1), where, ArticleDTO.class);
        System.out.println(articleDTOPage);
    }


    /**
     * 批量新增
     * 小批量适用,大批量使用
     * INSERT INTO `tb_account`(`user_name`, `age`, `birthday`) VALUES ('test-9', 0, '2023-08-02 15:39:51')
     * , ('test-8', 0, '2023-08-02 15:39:51'), ('test-7', 0, '2023-08-02 15:39:51'), ('test-6', 0, '2023-08-02 15:39:51')
     * , ('test-5', 0, '2023-08-02 15:39:51'), ('test-4', 0, '2023-08-02 15:39:51')
     * , ('test-3', 0, '2023-08-02 15:39:51'), ('test-2', 0, '2023-08-02 15:39:51'), ('test-1', 0, '2023-08-02 15:39:51')
     */
    @Test
    public void insert() {
        int count = 10;
        ArrayList<Account> accounts = new ArrayList<>();
        while (--count > 0) {
            Account account = new Account();
            account.setUserName("test-" + count);
            account.setAge(0);
            account.setBirthday(new Date());
            accounts.add(account);
        }

        int i = accountMapper.insertBatch(accounts);
        System.out.println(i);

    }

    /**
     * 批量新增-大批量,使用Db.executeBatch
     */
    @Test
    public void insertBatch() {
        int count = 10;
        ArrayList<Account> accounts = new ArrayList<>();
        while (--count > 0) {
            Account account = new Account();
            account.setUserName("test-" + count);
            account.setAge(0);
            account.setBirthday(new Date());
            accounts.add(account);
        }

        Db.executeBatch(accounts.size(), 2, AccountMapper.class, (mapper, index) -> {
            Account account = accounts.get(index);
            mapper.insert(account);
        });

    }

    @Test
    public void delete() {
        int i = accountMapper.deleteByCondition(ACCOUNT.USER_NAME.like("test"));
        System.out.println(i);
    }
}
