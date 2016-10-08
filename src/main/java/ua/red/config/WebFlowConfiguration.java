package ua.red.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.faces.config.AbstractFacesFlowConfiguration;
import org.springframework.faces.webflow.FlowFacesContextLifecycleListener;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;

/**
 * WebFlowConfiguration, use /WEB-INF/flows folder for flows
 */
@Configuration
public class WebFlowConfiguration extends AbstractFacesFlowConfiguration {

    public WebFlowConfiguration() {
    }

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder ()
                .setBasePath ( "/WEB-INF/flows" )
                .addFlowLocationPattern ( "/**/*.xml" )
                .setFlowBuilderServices ( flowBuilderServices () )
                .build ();
    }

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder ( flowRegistry () )
                .addFlowExecutionListener( new FlowFacesContextLifecycleListener())
                .build ();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
                .setDevelopmentMode ( true )
                .build();
    }

}

