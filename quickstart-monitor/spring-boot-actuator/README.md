## 引入依赖包
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

## 配置actuator
* SpringBoot 2.x 默认只开放了两个端点`/actuator/health`和`/actuator/info`
* 打开所有的监控点:`management.endpoints.web.exposure.include=*`
* 监控入口默认为`/actuator/*`，可通过设置base-path进行自定义
* （未验证）actuator/shutdown并不能优雅关机，已经接收的请求它会直接断掉，并且报上下文已经关了,而并不是等这个请求执行完
* Actuator接口不会显示在swagger页面，但是项目启动后可以在"Endpoints"-"Mappings"上看到
 
```yaml
server:
  port: 8888

management:
  endpoints:
    web:
      exposure:
        include: "*"  #SpringBoot 2.x 默认只开放了两个端点/actuator/health 和 /actuator/info，这里打开所有的监控点
      base-path: /monitor #监控路径默认为/actuator/*，这里自定义为/monitor
  endpoint:
    health:
      show-details: always
    shutdown:
      enabled: true 
  health:
    redis:
      enabled: false # 关闭redis的健康检查

info:
  app:
    name: spring-boot-actuator
    version: 1.0.0
    test: test
```

## 附录
Actuator 提供了 13 个接口，具体如下表所示。

|HTTP方法|路径|描述|
|---|---|---|
|GET|	/auditevents	|显示应用暴露的审计事件 (比如认证进入、订单失败)|
|GET|	/beans	|描述应用程序上下文里全部的 Bean，以及它们的关系|
|GET|	/conditions	|就是 1.0 的 /autoconfig ，提供一份自动配置生效的条件情况，记录哪些自动配置条件通过了，哪些没通过|
|GET|	/configprops	|描述配置属性(包含默认值)如何注入Bean|
|GET|	/env	|获取全部环境属性|
|GET|	/env/{name}	|根据名称获取特定的环境属性值|
|GET|	/flyway	|提供一份 Flyway 数据库迁移信息|
|GET|	/liquidbase	|显示Liquibase 数据库迁移的纤细信息|
|GET|	/health	|报告应用程序的健康指标，这些值由 HealthIndicator 的实现类提供|
|GET|	/heapdump	|dump 一份应用的 JVM 堆信息|
|GET|	/httptrace	|显示HTTP足迹，最近100个HTTP request/repsponse|
|GET|	/info	|获取应用程序的定制信息，这些信息由info打头的属性提供|
|GET|	/logfile	|返回log file中的内容(如果 logging.file 或者 logging.path 被设置)|
|GET|	/loggers	|显示和修改配置的loggers|
|GET|	/metrics	|报告各种应用程序度量信息，比如内存用量和HTTP请求计数|
|GET|	/metrics/{name}	|报告指定名称的应用程序度量值|
|GET|	/scheduledtasks	|展示应用中的定时任务信息|
|GET|	/sessions	|如果我们使用了 Spring Session 展示应用中的 HTTP sessions 信息|
|POST|	/shutdown	|关闭应用程序，要求endpoints.shutdown.enabled设置为true|
|GET|	/mappings	|描述全部的 URI路径，以及它们和控制器(包含Actuator端点)的映射关系|
|GET|	/threaddump	|获取线程活动的快照|

## 参考
* [Spring Boot (十九)：使用 Spring Boot Actuator 监控应用](http://www.ityouknow.com/springboot/2018/02/06/spring-boot-actuator.html)