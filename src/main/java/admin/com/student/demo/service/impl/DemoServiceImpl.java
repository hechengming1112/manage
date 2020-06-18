package admin.com.student.demo.service.impl;

import admin.com.student.demo.domain.Demo;
import admin.com.student.demo.mapper.DemoMapper;
import admin.com.student.demo.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private DemoMapper demoMapper;

    @Override
    public List<Demo> getDemoList() {
        return demoMapper.getDemoList();
    }
}
