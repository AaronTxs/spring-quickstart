使用Spring-Boot-Admin监控Spring Boot单体服务
===

## 1.服务端设置
### 1.1 引入依赖包
```xml
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-server</artifactId>
    <version>2.1.5</version>
</dependency>
```

### 1.2 标记Server端
```java
@EnableAdminServer
@SpringBootApplication
public class SpringBootMonitorAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMonitorAdminServerApplication.class, args);
    }
}
```

### 1.3 配置Server端
这里可以使用默认端口8080，我的该端口被占用，所以更改了
```yaml
server:
  port: 8888
```

## 2.服务端设置
### 2.1 引入依赖包
```xml
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
    <version>2.1.5</version>
</dependency>
```

### 2.2 配置Client端
1. 这里Client不需要用注解标注，直接在配置文件里设置Server端地址即可。
2. 需要打开客户端的Actuator监控(参考spring-boot-actuator)，否则读取不到客户端具体信息

```yaml
server:
  port: 9999
spring:
  application:
    name: admin-client
  boot:
    admin:
      client:
        url: http://localhost:8888  # 配置spring boot admin server 地址
management:
  endpoints:
    web:
      exposure:
        include: "*"  #打开客户端 Actuator 的监控，如果不放开的话，server端只能监控到client实例，拿不到详细信息
```

## 3.邮件告警（未完成）
### 3.1 Server端引入邮件依赖包
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
```

### 3.2 Server端配置邮件发送信息
这里使用hMailServer搭建的本地邮件服务器，权限通了，但是邮箱里未发现有收到邮件（后面检查）

```yaml
spring:
  mail:
    host: localhost
    username: xiecf@localmail
    password: 123456
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: false # hMailServer 搭建的本地邮箱，没有特别设置认证
            required: false # 同上
  boot:
    admin:
      notify:
        mail:
          from: xiecf@localmail
          to: xiecf@localmail
```
## 参考
* [Spring Boot(二十)：使用 spring-boot-admin 对 Spring Boot 服务进行监控](http://www.ityouknow.com/springboot/2018/02/11/spring-boot-admin.html)
* [使用spring-boot-admin对spring-boot服务进行监控](https://www.cnblogs.com/shihaiming/p/8488939.html)

## 延伸
* Spring Boot Admin 身份认证
* Spring Boot Admin 邮件告警模板定制处理
