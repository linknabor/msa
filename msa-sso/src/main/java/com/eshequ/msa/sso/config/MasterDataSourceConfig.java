/**
 * 
 */
package com.eshequ.msa.sso.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * 主数据源
 * @author davidhardson
 *
 */
@Configuration
@Profile("dev-multi-datasource")
@MapperScan(basePackages = "com.eshequ.msa.sso.mapper", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.druid.one")
	public DataSourceProperties masterDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		return masterDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
    	
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        return sessionFactory.getObject();
    }
	
	
}
