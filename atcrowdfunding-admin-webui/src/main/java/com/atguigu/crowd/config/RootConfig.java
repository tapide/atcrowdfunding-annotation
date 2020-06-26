package com.atguigu.crowd.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@PropertySource("classpath:jdbc.properties")
@MapperScan("com.atguigu.crowd.dao")
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan(value = "com.atguigu",excludeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})})
public class RootConfig {


    @Value("${jdbc.url}")
    private  String  url;
    @Value("${jdbc.username}")
    private  String  username;
    @Value("${jdbc.password}")
    private  String  password;
    @Value("${jdbc.driver}")
    private  String  driver;


    //配置数据源
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    //配置事务管理器
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return   new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //注入数据源
        factoryBean.setDataSource(dataSource());
        //指定mapper映射文件的路径
        PathMatchingResourcePatternResolver resource = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resource.getResources("classpath:mapper/*Mapper.xml"));
//        //配置分页插件
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties props = new Properties();
//        props.setProperty("helperDialect", "mysql");
//        props.setProperty("supportMethodsArguments", "true");
//        props.setProperty("rowBoundsWithCount", "true");
//        pageInterceptor.setProperties(props);
//        factoryBean.setPlugins(pageInterceptor);
        return factoryBean;
    }


}
