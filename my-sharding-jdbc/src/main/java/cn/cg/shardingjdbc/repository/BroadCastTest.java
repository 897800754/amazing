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
public class BroadCastTest {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private Integer type;

    private Integer channel;

    private String name;

}
