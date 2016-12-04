package org.ncedu.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;


@Configuration
@ComponentScan("org.ncedu")
@EnableWebMvc
@EnableTransactionManagement
@Import({WebAppSocketConfig.class})
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public DataSource dataSource () {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@172.16.172.107:1521/orcl");
        dataSource.setUsername("admin");
        dataSource.setPassword("1");
        return dataSource;
    }
    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory () throws Exception {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        sessionFactoryBean.setPackagesToScan("org.ncedu.entity");  // tut
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();

    }

    @Bean(name = "hibernateTemplate")
    public HibernateTemplate hibernateTemplate () throws Exception {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory());
        hibernateTemplate.afterPropertiesSet();
        return hibernateTemplate;
    }

    @Bean(name = "hibernateTransactionManager")
    public HibernateTransactionManager hibernateTransactionManager() throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        transactionManager.afterPropertiesSet();
        return transactionManager;
    }

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
