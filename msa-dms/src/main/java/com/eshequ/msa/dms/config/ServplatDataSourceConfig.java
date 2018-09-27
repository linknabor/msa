/**
 * 
 */
package com.eshequ.msa.dms.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * servplat数据源
 * @author davidhardson
 *
 */
@Configuration
@MapperScan(basePackages = "com.eshequ.msa.dms.mapper.servplat", sqlSessionFactoryRef = "servplatSqlSessionFactory")
public class ServplatDataSourceConfig {
	
	@Value("${mybatis.mapper.resource}")
	private String mapperResource;

	@Autowired
	private Environment env;
	
	@Bean(name = "servplatDataSource")
	public DataSource servplatDataSource() {
		DataSource dataSource = DruidDataSourceBuilder.create().build(env, "spring.datasource.druid.servplat.");
		return dataSource;
	}
	
    @Bean(name = "servplatTransactionManager")
    public DataSourceTransactionManager servplatTransactionManager() {
        return new DataSourceTransactionManager(servplatDataSource());
    }

    @Bean(name = "servplatSqlSessionFactory")
    public SqlSessionFactory customSqlSessionFactory(@Qualifier("servplatDataSource") DataSource servplatDataSource)
            throws Exception {
    	
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(servplatDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources(mapperResource));
        return sessionFactory.getObject();
    }
	
	
}
