使用 Docker 部署 Spring Boot分如下三种方式，可独立使用，新手可以依次学习使用
> 1. 本地打包，云服务器编译镜像并运行容器
代码：`quickstart-docker`
> 2. 云服务器根据Dockfile依次镜像打包、镜像编译/运行 代码：`quickstart-docker-maven`
> 3. Jenkins（其他ci/cd工具类似）实现自动部署、打包、镜像编译/上传/运行 代码：`quickstart-docker-jenkins`