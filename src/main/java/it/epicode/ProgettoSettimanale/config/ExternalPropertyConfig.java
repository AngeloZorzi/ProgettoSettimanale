package it.epicode.ProgettoSettimanale.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

    @Configuration
    @PropertySource("file:./env.properties")  // percorso relativo a dove avvii l'app
    public class ExternalPropertyConfig {
    }

