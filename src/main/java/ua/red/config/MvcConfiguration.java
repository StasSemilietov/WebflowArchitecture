package ua.red.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.mvc.JsfView;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

/**
 * MVC configuration/
 * Configures Spring WebFlow in context of Spring MVC.
 */

@EnableWebMvc
@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private WebFlowConfiguration webFlowConfig;


    /**
     *  FlowHandlerMapping
     */
    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
        handlerMapping.setOrder(-1);
        handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
        return handlerMapping;
    }
    /**
     *  FlowHandlerAdapter
     */
    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
        return handlerAdapter;
    }
    /**
     *  ViewResolver, use standard /WEB-INF/ folder for views and pages
     */
    @Bean
    public ViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver ();
        urlBasedViewResolver.setViewClass( JsfView.class);
        urlBasedViewResolver.setPrefix ( "/WEB-INF/views/" );
        urlBasedViewResolver.setSuffix ( ".xhtml" );
        return urlBasedViewResolver;
    }
    /**
     *  DispatcherServlet, mapping for "/" and "app/*"
     */
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet ();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean (
                dispatcherServlet(), "/app/*" );
        registration.addUrlMappings("/");
        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return registration;
    }

    /**
     * View controller, as XML-style 'welcome-page-list'
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // forward requests to '/' to its index.html
        registry.addViewController("/").setViewName(
                "index");

    }




}