# 校园商铺

记录整理学习 o2o 项目过程中的知识及理解，梳理自己的认识。

## 一、主流技术及工具

**产品迭代：** Spring MVC + spring + MyBaties -> SpringBoot + MyBatis

**前端：** SUI Mobile

**后端：** redis、MySql

**环境：** JDK1.8、Maven3.3.9、MySQL5.5+、Chrome、TomCat8、Eclipse

## 二、环境配置

JDK配置、Maven配置、TomCat配置

**创建项目：** 创建 maven-webapp 项目

**添加类库：** 在 Java Build Path 中将 TomCat 类库添加到 Libraries （不添加会报 HttpServlet not found 错误）

**更改执行环境：** 将执行环境更改到 JDK1.8，在 pom 文件中添加 Maven 的编译依赖工具（加入到 build中）

```xml
<plugins>
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.6.1</version>
        <configuration>
            <source>1.8</source>
            <target>1.8</target>
            <encoding>UTF8</encoding>
        </configuration>
    </plugin>
</plugins>
```

**添加 SourceFolder：** 在项目中添加 test/resources  SF，并在 Source 中更改其输出路径到 test-classes

**更改模型解析版本：** 更改 facet 的版本号为 3.1（.settings\org.eclipse.wst.common.project.facet.core.xml）

**更改 Web.xml 中的规范：** 将 2.3 更改为 3.1

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1" metadata-complete="true">
```

## 三、系统功能划分

**超级管理员系统：** 

![超级管理员系统](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E5%88%92%E5%88%86/%E8%B6%85%E7%BA%A7%E7%AE%A1%E7%90%86%E5%91%98%E7%B3%BB%E7%BB%9F.png>)

------

**前端展示系统：** 

![前端展示系统](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E5%88%92%E5%88%86/%E5%89%8D%E7%AB%AF%E5%B1%95%E7%A4%BA%E7%B3%BB%E7%BB%9F.png>)

------

**店家系统：** 

![店家系统](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E5%88%92%E5%88%86/%E5%BA%97%E5%AE%B6%E7%B3%BB%E7%BB%9F.png>)

## 四、实体类设计

**实体类解析：** 

![实体类解析](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E5%AE%9E%E4%BD%93%E7%B1%BB/001-%E5%AE%9E%E4%BD%93%E7%B1%BB%E8%A7%A3%E6%9E%90.png>)

[主要实体类与数据库表设计](https://github.com/Kdocke/CampuShop1.0/blob/master/note/%E4%B8%BB%E8%A6%81%E5%AE%9E%E4%BD%93%E7%B1%BB%E4%B8%8E%E6%95%B0%E6%8D%AE%E5%BA%93%E8%A1%A8%E8%AE%BE%E8%AE%A1.md)

## 五、知识点

**1.SpringMVC:DispatcherServlet: ** DispatcherServlet是整个 MVC 框架中最为核心的一部分，主要用来拦截符合要求的外部请求，并把请求分发到不同的控制器中去，根据控制器处理后的结果，生成相应的响应，发送到客户端。

**2.SpringMVC:IOC和AOP: ** 

* IOC: 依赖自动注入
* AOP: 切面编程

**3.MyBatis:ORM: ** ORM 是通过使用描述对象和数据库映射之间的元数据，将程序中的数据自动持久化到关系型数据库中。