package pl.dmcs.mordaka.arkadiusz.app.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.dmcs.mordaka.arkadiusz.app.converter.BuildingToBuildingView;
import pl.dmcs.mordaka.arkadiusz.app.converter.LocalToLocalView;
import pl.dmcs.mordaka.arkadiusz.app.converter.RoleToRoleView;
import pl.dmcs.mordaka.arkadiusz.app.converter.UserToUserView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.dmcs.mordaka.arkadiusz.app")
public class WebConfig implements WebMvcConfigurer {

    private final RoleToRoleView roleToRoleView;
    private final BuildingToBuildingView buildingtoBuildingView;
    private final UserToUserView userToUserView;
    private final LocalToLocalView localToLocalView;

    public WebConfig(RoleToRoleView roleToRoleView, BuildingToBuildingView buildingtoBuildingView, UserToUserView userToUserView, LocalToLocalView localToLocalView) {
        this.roleToRoleView = roleToRoleView;
        this.buildingtoBuildingView = buildingtoBuildingView;
        this.userToUserView = userToUserView;
        this.localToLocalView = localToLocalView;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("lang");
        registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }


    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setFallbackToSystemLocale(false);
        messageResource.setBasename("classpath:i18n/messages");
        messageResource.setDefaultEncoding("UTF-8");
        return messageResource;
    }

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieDomain("myAppLocaleCookie");
        resolver.setCookieMaxAge(60 * 60);
        return resolver;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToRoleView);
        registry.addConverter(buildingtoBuildingView);
        registry.addConverter(userToUserView);
        registry.addConverter(localToLocalView);
    }
}
