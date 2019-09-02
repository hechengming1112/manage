package admin.com.student.demo.controller;

import admin.com.student.demo.domin.Demo;
import admin.com.student.demo.service.DemoService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 和诚明
 * @date 2019/09/02
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

       private static final Logger log = LoggerFactory.getLogger(DemoController.class);
       @Autowired
       private DemoService demoService;
       @RequestMapping("/getDemoList")
       public List<Demo> getDemoList(){

              List<Demo> demoList = demoService.getDemoList();
              log.info("param:{}",demoList);
              return demoList;

       }

}
