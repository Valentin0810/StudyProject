package com.varvashevich.configuration;

import com.varvashevich.dbconfiguration.DataBaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.varvashevich.service")
@Import(DataBaseConfiguration.class)
public class ServiceConfiguration {
}