[TOC]
# 1.为什么要引入lombok?
通常定义实体Bean时需要编写大量重复的Getter/Setter方法，实在是很麻烦。
最初知道lombok就是为了解决这个问题，lombok可以在运行时自动生成这些代码，大大简化实体定义。

# 2.快速使用lombok三步法
## 2.1 IDE安装lombok插件

我用的eclipse，所以这里只讲eclipse中`lombok`插件安装

`lombok`官网：<https://projectlombok.org/>
`lombok jar`：<https://projectlombok.org/download>

1. 下载`lombok.jar`

2. 复制`lombok.jar`到eclipse安装目录下

3. 编辑`eclipse.ini`，添加`-javaagent:lombok.jar`

4. 重启eclipse

5. 清理项目或更新项目

   ps： 步骤2和3也可以，也可以直接双击运行lombok.jar，弹出页面`specify location`选择eclipse安装目录，点击`install/update`安装。

   该动作会把`lombok.jar`拷贝到eclipse目录，并完成对`eclipse.ini`的修改

## 2.2 项目中引入lombok

```xml
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>			 
</dependency>
```

## 2.3 定义实体

```java
package aaron.springbootlombok.model;

import lombok.Data;

@Data
public class User {
	private String name;
	private int age;
}
```
注意：

*  添加了**@Data**注解，
* 不用编写Getter/Setter方法了

# 3 测试效果

```java
package aaron.springbootlombok;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import aaron.springbootlombok.model.User;

@SpringBootTest
public class UserTest {

	@Test
	public void testUser() {
		User user = new User();
		user.setName("aaa");
		user.setAge(18);

		assertEquals(user.getAge(), 18);
		assertEquals(user.getName(), "aaa");
	}
}
```
注意：

setXyz/getXyz这些都没有在实体里定义，是运行时lombok帮忙生成的。

# 4.lombok进阶使用

lombok官方支持功能可以参见【延伸阅读】链接，这里只做简单说明

[Lombok features](https://projectlombok.org/features/all) features页面标注了lombok目前支持的功能特性（包括[实验特性](https://projectlombok.org/features/experimental/all)） 

点击各个功能对应链接可以发现详情页面基本分为五部分：

| 序号    |主题      |说明      |
| ---- | ---- | ---- |
|  1    |  Overview    | 概述，解释功能特性的用途 |
|  2    |  With Lombok    | 示例代码，使用Lombok的功能特性实现 |
|  3    |  Vanilla Java    | 示例代码，使用常规Java写法 |
|  4    |  Supported configuration keys    | 支持的配置项 |
|  5    |  Small print    | 注意事项 |

具体支持的功能特性参见附录

# 5.lombok优缺点

优点：
*  减少大量get/set方法
*  代码可读性高，关注属性，而不是属性操作方法
* 扩展方便，新增属性时，不需要改动toString/hash/equal方法

缺点：

*  需要ide支持lombok插件
* 无法查看自动生成的方法被引用情况 

# 附录

| 功能特性（关键字/注解）                                      | 功能说明                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [`val`](https://projectlombok.org/features/val)              |                                                              |
| [`var`](https://projectlombok.org/features/var)              |                                                              |
| [`@NonNull`](https://projectlombok.org/features/NonNull)     |                                                              |
| [`@Cleanup`](https://projectlombok.org/features/Cleanup)     | 自动资源管理：不用再在finally中添加资源的close方法           |
| [`@Getter/@Setter`](https://projectlombok.org/features/GetterSetter) | 自动生成set和get方法                                         |
| [`@ToString`](https://projectlombok.org/features/ToString)   | 自动生成toString方法                                         |
| [`@EqualsAndHashCode`](https://projectlombok.org/features/EqualsAndHashCode) | 从对象的字段中生成hashCode和equals的实现                     |
| [`@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor`](https://projectlombok.org/features/constructor) | 自动生成构造方法                                             |
| [`@Data`](https://projectlombok.org/features/Data)           | 自动生成set/get方法，toString方法，equals方法，hashCode方法，不带参数的构造方法 |
| [`@Value`](https://projectlombok.org/features/Value)         | 用于注解final类                                              |
| [`@Builder`](https://projectlombok.org/features/Builder)     | 实例化这个类                                                 |
| [`@SneakyThrows`](https://projectlombok.org/features/SneakyThrows) | 异常处理（谨慎使用）                                         |
| [`@Synchronized`](https://projectlombok.org/features/Synchronized) | 对标记对象进行加锁，不需要直接定义锁                         |
| [`@Getter(lazy=true)`](https://projectlombok.org/features/GetterLazy) |                                                              |
| [`@Log`](https://projectlombok.org/features/log)             |                                                              |
| [`experimental`](https://projectlombok.org/features/experimental/all) |                                                              |



# 延伸阅读

* [Lombok features](https://projectlombok.org/features/all)