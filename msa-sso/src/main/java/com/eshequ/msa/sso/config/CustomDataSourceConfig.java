/**
 * 
 */
package com.eshequ.msa.sso.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 从数据源
 * @author davidhardson
 *
 */
@Configuration
@Profile("dev-multi-datasource")
@MapperScan(basePackages = "com.eshequ.msa.codes.mapper", sqlSessionFactoryRef = "customSqlSessionFactory")
public class CustomDataSourceConfig {
	
	@Value("${mybatis.mapper.resource}")
	private String mapperResource;

	@Bean
	@ConfigurationProperties("spring.datasource.druid.two")
	public DataSourceProperties customDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "customDataSource")
	public DataSource customDataSource() {
		
		DataSourceProperties prop = customDataSourceProperties();
		return prop.initializeDataSourceBuilder().build();
	}
	
    @Bean(name = "customTransactionManager")
    public DataSourceTransactionManager customTransactionManager() {
        return new DataSourceTransactionManager(customDataSource());
    }

    @Bean(name = "customSqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("customDataSource") DataSource customDataSource)
            throws Exception {
    	
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(customDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources(mapperResource));
        return sessionFactory.getObject();
    }
	
	
}
