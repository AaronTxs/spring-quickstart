# 1.多环境配置
开发、测试、生产环境，有一些配置不一样，来回修改很麻烦，又容易遗漏。
Profile是Spring对不同环境提供不同配置功能的支持，可以通过激活、指定参数等方式快速切换环境。

*  激活方式

只需要在`application.yml`中指定环境即可。

```yaml
spring:
  profiles:
    active: dev
```

* 指定参数

也可以将项目打包为jar，运行时指定环境变量即可，如`java -jar spring-boot-multi-profiles.jar --spring.profiles.active=test`

# 2.多文件实现多环境配置（推荐）
文件名格式为：`application-{profile}.properties`或`application-{profile}.yml`

application.yml

```yaml
server:
  port: 8888

spring:
  profiles:
    active: dev
```

application-dev.yml

```yaml
server:
  port: 8001
```

application-test.yml

```yaml
server:
  port: 8002
```


# 3.单文件实现多环境配置
yml文件中支持使用三个短横线分割文档块的方式

其中default表示未指定时默认使用的配置

```yaml
server:
  port: 8888
spring:
  profiles:
    active: dev

---
#默认设置
spring:
  profiles: default
server:
  port: 9999
---
# 开发环境配置
spring:
  profiles: dev   
server:
   port: 9001
   
---
# 测试环境配置
spring:
  profiles: test   
server: 
  port: 9002   
```

# 4.配置文件优先级
优先级只针对同一个key有效，基本满足如下规则：

**1.application.properties>application.yml**

 验证方式：
 
 可以将两个文件中`spring.profiles.active`设置不同值，启动项目，看tomcat启动端口 

**2.application-{profile}.yml>application.yml**

验证方式：

只保留`application-{profile}.yml`和`application.yml`，启动项目，看tomcat启动端口

# 延伸阅读
* [SpringBoot配置加载，各配置文件优先级对比](https://blog.csdn.net/it_faquir/article/details/80869578)