package com.hodor.rpm.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 */
@Configuration
@Profile("dev")
@PropertySource("classpath:application-dev.properties")
public class DevConfiguration  {

    @Autowired
    private Environment env;

}
