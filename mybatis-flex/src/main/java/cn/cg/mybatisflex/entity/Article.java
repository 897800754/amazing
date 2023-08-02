package cn.cg.mybatisflex.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

@Data
@Table("tb_article")
public class Article {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private Long accountId;
    private String title;
    private String content;

}
