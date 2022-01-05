package com.acrossatto.preference.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class ValidationConfig {

    @Bean
    fun source() = ReloadableResourceBundleMessageSource().apply {
        setBasename("classpath:messages")
        setDefaultEncoding("UTF-8")
    }

    @Bean
    fun validator() = LocalValidatorFactoryBean().apply {
        setValidationMessageSource(source())
    }
}