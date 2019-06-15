# SpringBoot项目集成Mybatis

## 如何集成
### 1. 创建SpringBoot项目
引入下面依赖：
* org.mybatis.spring.boot：mybatis-spring-boot-starter
* org.springframework.boot：spring-boot-starter-jdbc
* mysql：mysql-connector-java

本案例以web为例，所以也要引入
* org.springframework.boot：spring-boot-starter-web

### 2. 配置jdbc、mybatis
```xml
spring:
  datasource:
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/springquiskstart?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  mapper-locations: classpath:mapping/*Mapping.xml
  type-aliases-package: aaron.springbootmybatis.entity

#showSql
logging:
  path: /log
  level:
    aaron:
      mapper : debug
```

### 3.实现简单查询业务
#### 3.1 创建表User
```sql
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) NOT NULL,
  `reg_time` datetime DEFAULT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

#### 3.2 创建实体类并实现查询
依次创建如下分级目录和文件

####

## 遇到的坑
Q1: 出现错误`org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)`

A1: 绑定错误，基本是配置出错

[解决org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)问题](https://blog.csdn.net/sundacheng1989/article/details/81630370)
这里列举的原因我就遇到两个：
1. xml文件所在package名称和Mapper Interface包名不一致
    `<mapper namespace="aaron.springbootmybatis.mapper.UserMapper">`
2. Mapper Interface文件名和xml文件名不一致 

另外几个感觉需要注意的地方有：
1. Mapper Interface中方法返回的是列表类型List<T>，但xml中select元素没有配置RestltMap，或只配置了ResultType
2. 默认配置文件中mapper的配置路径不正确
```xml
mybatis:
  mapper-locations: classpath:mapping/*Mapper.xml
  type-aliases-package: aaron.springbootmybatis.entity
```

网上资料里面有的没强调类名要和xml文件名保持一致，所以应该还有其他深层规则，仔细思考了下，结合上述的两个第二点，发现进行如下修改后也是可以的：
```java
1. UserMapper.xml --> UserMapping.xml
2. classpath:mapping/*Mapper.xml --> classpath:mapping/*Mapping.xml
```

也就是说: ***Mapper Interface文件名和xml文件名是否需要一致还得看xml文件的扫描规则***

## 参考
* [SpringBoot整合Mybatis完整详细版](https://blog.csdn.net/iku5200/article/details/82856621)
* [Spring Boot(六)：如何优雅的使用 Mybatis](https://www.cnblogs.com/ityouknow/p/6037431.html)

## 延伸阅读
* [IDEA下使用MyBatisCodeHelper插件](https://blog.csdn.net/HcJsJqJSSM/article/details/84348966)