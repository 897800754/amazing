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
public class TestItemRepository extends ServiceImpl<TestItemMapper, TestItem> implements IService<TestItem> {

    public List<TestItem> findByType(Integer type) {
        LambdaQueryWrapper<TestItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TestItem::getType, type);
        return this.baseMapper.selectList(wrapper);
    }

    public List<TestItem> findByChannel(int channel) {
        LambdaQueryWrapper<TestItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TestItem::getChannel, channel);
        return this.baseMapper.selectList(wrapper);
    }

    public List<TestItem> findByWrapper(LambdaQueryWrapper<TestItem> wrapper) {
        return this.baseMapper.selectList(wrapper);
    }
}
