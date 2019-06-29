package aaron.springbootdocker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiecf
 * @title: TimeController
 * @projectName sping-quickstart
 * @date 2019/06/03 09:49
 * @description: TODO
 */
@Slf4j
@RestController
@RequestMapping("/time")
public class TimeController {
    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS" );

    @RequestMapping(method = RequestMethod.GET)
    public String getTime(){
        String time=sdf.format(new Date());
        log.info("当前时间为:"+time);
        return time;
    }
}
