package com.zzpzaf.se.devxperiences.posts.externalvalues.Properties;

// import java.util.Arrays;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import org.springframework.web.servlet.LocaleResolver;
// import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import com.zzpzaf.se.devxperiences.posts.externalvalues.Validators.TableNamesPropertiesValidator;

@Configuration
@PropertySource(value="classpath:db-objects.props", ignoreResourceNotFound=true)
@ConfigurationPropertiesScan()
public class PropConfig {
    
    //Section C
    @Bean
    public static TableNamesPropertiesValidator configurationPropertiesValidator() {
        return new TableNamesPropertiesValidator();
    }

    // Section D
    @Bean
    public MessageSource validationMessageSource() {
        ReloadableResourceBundleMessageSource messageSource  = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheMillis(10000);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(new Locale("de", "DE"));
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    @Bean
    @Qualifier("infoMessageSource")
    public MessageSource infoMessageSource() {
        ReloadableResourceBundleMessageSource messageSource  = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:information/infomessages");
        messageSource.setCacheMillis(10000);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(new Locale("el", "GR"));
        return messageSource;
    }



    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(validationMessageSource());
        return bean;
    }


    @Bean
    public LocaleResolver localeResolver() {
        final LocaleResolver resolver = new CustomLocaleResolver();
        // Locale[] acceptableLocals = {Locale.GERMANY, Locale.FRANCE, Locale.ENGLISH, Locale.US, Locale.forLanguageTag("el-GR") };
        // resolver.setSupportedLocales(Arrays.asList(acceptableLocals));
        // resolver.setDefaultLocale(Locale.US);
        return resolver;
    }

}
