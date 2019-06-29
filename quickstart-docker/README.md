## 编写Dockerfile
```sql
FROM openjdk:8u181-jdk-alpine
ARG workdir=/app
VOLUME ${workdir}
WORKDIR ${workdir}
ADD spring-boot-docker-0.0.1-SNAPSHOT.jar springboot-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","springboot-docker.jar"]
```

## 编译docker image
```sql
docker build -t springboot-docker . 
```
## 运行docker image
```
docker run -p 8080:8080 -d --name spring-boot-docker springboot-docker
```

* 查看最新运行的容器 `docker ps -n 1`或`docker ps -l`
* 删除容器 `docker rm 容器Id/name`
* 删除镜像 `docker rmi 镜像名` ,该镜像没有被容器引用

## 参考
* [docker - dockerfile构建一个简单的springboot应用镜像](https://my.oschina.net/thinwonton/blog/2967118)
* [Docker部署运行springboot项目，并使用Dockerfile制作镜像](https://www.cnblogs.com/spll/p/10059542.html)