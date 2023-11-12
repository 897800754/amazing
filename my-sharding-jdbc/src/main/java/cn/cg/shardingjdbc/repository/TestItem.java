package cn.cg.shardingjdbc.repository;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

/**
 * @author chengang
 */
@Data
@Builder
public class TestItem {
    @TableId(type = IdType.AUTO)
    private String id;

    private String testId;

    private Integer type;

    private Integer channel;

    private String name;

}
