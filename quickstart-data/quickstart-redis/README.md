## 引入依赖包
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
	<groupId>org.apache.commons</groupId>
	<artifactId>commons-pool2</artifactId>
</dependency>
```

## 配置Redis
```yaml
spring:
  redis:
    database: 0     # Redis数据库索引（默认为0）  
    host: localhost # Redis服务器地址
    port: 6379      # Redis服务器连接端口  
    password:       # Redis服务器连接密码（默认为空）
    lettuce:
      pool: 
        max-active: 8 # 连接池最大连接数（使用负值表示没有限制） 默认 8
        max-wait: -1  # 连接池最大阻塞等待时间（使用负值表示没有限制） 默认 -1
        max-idle: 8   # 连接池中的最大空闲连接 默认 8
        min-idle: 0   # 连接池中的最小空闲连接 默认 0
```