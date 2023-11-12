package cn.cg.shardingjdbc.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: cg
 * @date: 2022-11-30 14:41
 **/
@Service
public class TestRepository extends ServiceImpl<TestMapper, Test> implements IService<Test> {

    public List<Test> findByType(Integer type) {
        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Test::getType, type);
        return this.baseMapper.selectList(wrapper);
    }

    public List<Test> findByChannel(int channel) {
        LambdaQueryWrapper<Test> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Test::getChannel, channel);
        return this.baseMapper.selectList(wrapper);
    }

    public List<Test> findByWrapper(LambdaQueryWrapper<Test> wrapper) {
        return this.baseMapper.selectList(wrapper);
    }
}
