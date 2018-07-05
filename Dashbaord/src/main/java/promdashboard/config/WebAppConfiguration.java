/**
 *
 */
package promdashboard.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import promdashboard.dao.GraphDAOImpl;
import promdashboard.dao.PersonDao;
import promdashboard.dao.PersonDaoImp;

/**
 * @author Ibrahim-Abdullah
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "promdashboard")
@EnableRdsInstance(dbInstanceIdentifier = "iabdullah-promytheus",password = "0030104018profib")
//@PropertySource(value = { "classpath:application.properties" })
@EnableWebMvc
public class WebAppConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        ///engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(1);
        return resolver;
    }

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/promytheus");
//        dataSource.setUsername("promytheus");
//        dataSource.setPassword("PR0myTheu$");
//        return dataSource;
//    }
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://iabdullah-promytheus.ch8x30yeh8ne.us-east-2.rds.amazonaws.com:5432/promytheus");
//        dataSource.setUsername("iabdullah");
//        dataSource.setPassword("0030104018profib");
//        return dataSource;
//    }
//
//    @Bean
//    public PersonDao getPersonDao() {
//        return new PersonDaoImp(getDataSource());
//    }
//
//    @Bean
//    public GraphDAOImpl getGraphDAOImpl() {
//        return new GraphDAOImpl(getDataSource());
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }
}
