package cn.cg.shardingjdbc.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestMapper extends BaseMapper<Test> {

    //    @Select("select * from test t  inner join test_item it on t.id =it.test_id where t.channel =  #{channel} and t.type = #{type} and it.channel =  #{channel} and it.type = #{type}")
    @Select("select * from test t  inner join test_item it on t.id =it.test_id where t.channel =  #{channel} and t.type = #{type}")
    List<Map> selectWithItem(@Param("channel") Integer channel, @Param("type") Integer type);
}
