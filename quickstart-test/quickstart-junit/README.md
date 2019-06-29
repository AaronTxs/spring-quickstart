```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
</dependency>
```

## 遇到的坑

Q1. 执行测试方法时报错`java.lang.IllegalStateException: Found multiple @SpringBootConfiguration annotated classes `

A: 一般是项目工程中多个类被标注为@SpringBootConfiguration 引起的，不过我当前工程并没有这么多，只有一个。看到[https://m.imooc.com/qadetail/278775](https://m.imooc.com/qadetail/278775)这里猛然想起来，该工程之前都是Ok的，我改过项目命名空间后就没再跑通过。
果断使用Maven先Clean一遍再跑，确实成功了。

## 参考
* [学习 Spring Boot：（二十九）Spring Boot Junit 单元测试](https://blog.csdn.net/qq_35915384/article/details/80227297)
* [Spring Boot（十二）单元测试JUnit](https://www.cnblogs.com/vipstone/p/9908545.html)

## 延伸阅读
* [学习Spring Boot](https://blog.csdn.net/qq_35915384/article/details/80227297)
* [Spring、Spring Boot 和 TestNG 测试指南 ( 2 )](http://www.itboth.com/d/nYbiae/spring)
