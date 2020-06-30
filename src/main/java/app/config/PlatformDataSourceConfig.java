package app.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "app.dao.platform",sqlSessionFactoryRef = "platformSqlSessionFactory")
public class PlatformDataSourceConfig {
    @Primary
//    配置SqlSessionFactory,使用相应的DataSource
    @Bean("platformSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("platformDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/platform/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
//    配置SqlSessionTemplate，使用相应SqlSessionFactory
    @Bean("platformSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("platformSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
