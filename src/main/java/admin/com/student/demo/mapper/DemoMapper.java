package admin.com.student.demo.mapper;
import admin.com.student.demo.domin.Demo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 和诚明
 * @date 2019/09/02
 */
@Repository
public interface DemoMapper {
     List<Demo> getDemoList();
}
