package com.locoporf1.sandbox.sandboxserver.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
    "com.locoporf1.sandbox.sandboxserver.controllers"
})
@EnableAutoConfiguration
public class SpringWebConfig {



}
