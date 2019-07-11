package com.kdocke.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置 spring 和 junit 整合,junit 启动时加载 springIOC 容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉 junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}