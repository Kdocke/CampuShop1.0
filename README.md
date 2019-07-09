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

**前端展示系统：** 

![前端展示系统](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E5%88%92%E5%88%86/%E5%89%8D%E7%AB%AF%E5%B1%95%E7%A4%BA%E7%B3%BB%E7%BB%9F.png>)

**店家系统：** 

![店家系统](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E5%88%92%E5%88%86/%E5%BA%97%E5%AE%B6%E7%B3%BB%E7%BB%9F.png>)

## 四、实体类设计

**实体类解析：** 

![实体类解析](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E5%AE%9E%E4%BD%93%E7%B1%BB/001-%E5%AE%9E%E4%BD%93%E7%B1%BB%E8%A7%A3%E6%9E%90.png>)

**1. 区域实体类与数据库表设计** 

![区域实体类](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E5%AE%9E%E4%BD%93%E7%B1%BB/002-%E5%8C%BA%E5%9F%9F%E5%AE%9E%E4%BD%93%E7%B1%BB.png>)

```sql
CREATE DataBase `o2o`;
USE o2o;
CREATE TABLE `tb_area` (
  `area_id` int(2) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(200) NOT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `UK_AREA` (`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

补充：MySQL 主要包含两种引擎，一种是 INNODB，另一种是 MYISAM，区别是INNODB 是行级锁，支持事务，写性能更高；MYISAM 是表级锁，但读取更快。

**2. 用户实体类与数据库表设计**

![用户实体类](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E5%AE%9E%E4%BD%93%E7%B1%BB/003-%E7%94%A8%E6%88%B7%E5%AE%9E%E4%BD%93%E7%B1%BB.png>)

```sql
use o2o;
create table `tb_person_info`(
	`user_id` int(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(32) DEFAULT NULL,
	`profile_img` varchar(1024) DEFAULT NULL,
	`email` varchar(1024) DEFAULT NULL,
	`gender` varchar(2) DEFAULT NULL,
	`enable_status` int(2) NOT NULL DEFAULT '0' COMMENT '0:禁止使用本商城 1:允许使用本商城',
	`user_type` int(2) NOT NULL DEFAULT '1' COMMENT '1:顾客 2:店家 3:超级管理员',
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	primary key(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
```

**3. 用户帐号实体类与数据库表设计**

![用户帐号实体类](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E5%AE%9E%E4%BD%93%E7%B1%BB/004-%E7%94%A8%E6%88%B7%E5%B8%90%E5%8F%B7%E5%AE%9E%E4%BD%93%E7%B1%BB.png>)

```mysql
use o2o;
create table `tb_wechat_auth`(
	`wechat_auth_id` int(10) NOT NULL AUTH_INCREMENT,
	`user_id` int(10) NOT NULL,
	`open_id` varchar(1024) NOT NULL,
	`create_time` datetime DEFAULT NULL，
	primary key(`wechat_auth_id`),
	constraint `fk_wechatauth_profile` foreign key(`user_id`) references `tb_person_info`(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `tb_local_auth`(
	`local_auth_id` int(10) NOT NULL AUTO_INCREMENT,
	`user_id` int(10) NOT NULL,
	`username` varchar(128) NOT NULL,
	`password` varchar(128) NOT NULL,
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	PRIMARY KEY(`local_auth_id`),
	UNIQUE KEY `uk_local_profile`(`username`),
	constraint `fk_localauth_profile` foreign key(`user_id`) references `tb_person_info`(`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

alter table tb_wechat_auth add unique index(open_id)
```

**3. 头条实体类和数据库表设计**

![头条实体类](<https://raw.githubusercontent.com/Kdocke/MyDocumentImg/master/CampuShop1.0/%E5%AE%9E%E4%BD%93%E7%B1%BB/005-%E5%A4%B4%E6%9D%A1%E5%AE%9E%E4%BD%93%E7%B1%BB.png>)

```mysql
use o2o;
CREATE TABLE `tb_head_line`(
	`line_id` int(100) NOT NULL AUTO_INCREMENT,
	`line_name` varchar(1000) DEFAULT NULL,
	`line_link` varchar(2000) DEFAULT NULL,
	`line_img` varchar(2000) DEFAULT NULL,
	`priority` int(2) DEFAULT NULL,
	`enable_status` int(2) NOT NULL,
	`create_time` datetime DEFAULT NULL,
	`last_edit_time` datetime DEFAULT NULL,
	PRIMARY KEY(`line_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

