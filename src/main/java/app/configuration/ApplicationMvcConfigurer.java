package app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.stream.IntStream;

@Configuration
@EnableWebMvc
public class ApplicationMvcConfigurer implements WebMvcConfigurer {
  private static final String PREFIX = "classpath:/static";
  private static final String[] MAPPINGS = {"/colorpick/**","/css/**","/fonts/**","/icons/**","/images/**", "/js/**", "/linkup_images/**","/pictures.sailer.logos/**","/sass/**","/vendor.fontawesome-free/**", "/seller/**"};
  private static final String[] LOCATIONS = {"/colorpick/","/css/","/fonts/","/icons/","/images/", "/js/", "/linkup_images/","/pictures.sailer.logos/","/sass/","/vendor.fontawesome-free/", "/seller/"};

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (MAPPINGS.length != LOCATIONS.length)
      throw new IllegalArgumentException("MAPPINGS AND LOCATIONS SIZE SHOULD BE SAME");

    IntStream.range(0, MAPPINGS.length)
            .forEach(idx -> registry.addResourceHandler(MAPPINGS[idx])
                    .addResourceLocations(PREFIX + LOCATIONS[idx]));


  }
}
