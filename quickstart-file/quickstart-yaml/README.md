[TOC]

# 1.默认配置文件采用Yaml格式


1. 将application.properties重命名为application.yml
2. 内容按照[yaml格式](https://docs.spring.io/spring-boot/docs/1.2.3.RELEASE/reference/html/boot-features-external-config.html#boot-features-external-config-yaml)编写即可
	- Yaml不支持Tab，只支持空格
	-  键与值之间冒号后需要紧跟空格
	
```yaml
server:
  port: 8888
```

# 2.SpringBoot默认yaml解析器
SpringBoot的默认yaml解析器是`snakeyaml`
需要特别注意的是，有些yaml解析器能把on、off、yes、no解析为布尔值。

上述4个值如果刚好对应的是java的枚举值，则会报错`No converter found capable of converting from type [java.lang.Boolean] to type ...`，这时候需要将值加引号表示即可。
示例：

```yaml
spring:
  main:
    banner-mode: "off"
```
强烈推荐使用true、false来表示布尔值。	

# 附录
## 1. yaml解析器依赖关系

```
spring-boot-starter-web->spring-boot-starter->snakeyaml
```
小技巧：

可以通过Eclipse打开项目工程中的pom.xml文件，切换到`Dependency Hierarchy`选项卡，选中右侧的`Resolved Dependencies`中的`snakeyaml`,在左侧`Dependency Hierarchy`区域即会显示该组件的层级依赖关系。