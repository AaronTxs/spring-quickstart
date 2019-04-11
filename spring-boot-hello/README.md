# 工程简介
SpringBoot初始项目是个控制台程序，默认依赖`spring-boot-starter`，这里是利用web组件添加了一个Restful风格服务，web组件`spring-boot-starter-web`依赖`spring-boot-starter`。

# 认识pom
本工程是使用Maven管理，项目依赖的包信息全部在pom.xml文件中
在Eclipse中打开pom.xml，在`Dependencies`选项卡可以看到本项目依赖的外部组件，在`Dependency Hierarchy`选项卡可以看到每个组件的依赖关系。

spring-boot-starter-web依赖：
* spring-boot-starter
* jackson
* tomcat-embed
* spring web mvc

# 认识application.properties
该文件为项目的默认配置文件，格式为：“key:value”，key可以有多级，如：`server.port: 8888`

# 关闭启动banner
启动项目时，会在Console视图上打印SpringBoot的banner（可以看到当前使用的版本），可以通过以下方式关闭：

方式1：修改启动类入口参数

```java
SpringApplication.run(SpringBootHelloApplication.class, args);
```

修改为

```java
SpringApplication springApplication = new SpringApplication(SpringBootHelloApplication.class);
springApplication.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
springApplication.run(args);
```

方式2：在配置文件中设置（推荐）

```xml
spring.main.banner-mode:off
```
可选值有：off、console（默认值）、log，不区分大小写

如果以上两种方式都设置了，会以方案2的为准