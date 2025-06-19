package it.epicode.ProgettoSettimanale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.ResourcePropertySource;

@SpringBootApplication
public class ProgettoSettimanaleApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(ProgettoSettimanaleApplication.class);
		app.addInitializers(context -> {
			try {
				ConfigurableEnvironment env = context.getEnvironment();
				env.getPropertySources().addFirst(
						new ResourcePropertySource(new FileSystemResource("./env.properties"))
				);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
		app.run(args);
	}
}