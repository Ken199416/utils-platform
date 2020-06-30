package app.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


//  把DataSourceProperties注入到Spring容器中
    @Bean(name = "testDataProperties")
//    识别配置文件前缀
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSourceProperties testDataSourceProperties(){
        return new DataSourceProperties();
    }

//    把DataSource注入到Spring容器中，参数：DataSourceProperties，根据@Bean中的name进行区分
    @Bean(name = "testDataSource")
    public DataSource testDataSource(@Qualifier("testDataProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


//  把DataSourceProperties注入到Spring容器中
    @Bean(name = "proDataProperties")
//    识别配置文件前缀
    @ConfigurationProperties(prefix = "spring.datasource.pro")
    public DataSourceProperties proDataSourceProperties(){
        return new DataSourceProperties();
    }




//    把DataSource注入到Spring容器中，参数：DataSourceProperties，根据@Bean中的name进行区分
    @Bean(name = "proDataSource")
    public DataSource proDataSource(@Qualifier("proDataProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


    //    设定一个主要的配置文件
    @Primary
//  把DataSourceProperties注入到Spring容器中
    @Bean(name = "platformDataProperties")
//    识别配置文件前缀
    @ConfigurationProperties(prefix = "spring.datasource.platform")
    public DataSourceProperties platformDataSourceProperties(){
        return new DataSourceProperties();
    }

//    设定主要数据源
    @Primary
    //    把DataSource注入到Spring容器中，参数：DataSourceProperties，根据@Bean中的name进行区分
    @Bean(name = "platformDataSource")
    public DataSource platformDataSource(@Qualifier("platformDataProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
