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
//设置扫描的mapper在哪个包下，此包下的mapper都使用该配置类的DataSource，配置SqlSessionFactory
@MapperScan(basePackages = "app.dao.pro",sqlSessionFactoryRef = "proSqlSessionFactory")
public class ProDataSourceConfig {
    @Primary
//    配置SqlSessionFactory,使用相应的DataSource
    @Bean("proSqlSessionFactory")
    public SqlSessionFactory proSqlSessionFactory(@Qualifier("proDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/pro/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
//    配置SqlSessionTemplate，使用相应SqlSessionFactory
    @Bean("proSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("proSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
