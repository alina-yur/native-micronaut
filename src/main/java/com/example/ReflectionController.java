// ReflectionController.java
package com.example.demo;

import io.micronaut.core.annotation.ReflectionConfig;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import java.util.Arrays;

@Controller
@ReflectionConfig(
        type = Message.class,
        fields = {
                @ReflectionConfig.ReflectiveFieldConfig(name = "MESSAGE")
        }
)
public class ReflectionController {
    
    @Get("/reflection")
    public String message() {
        return getMessage();
    }
    
    private String getMessage() {
        try {
            String className = String.join(".", Arrays.asList("com", "example", "demo", "Message"));
            return (String) Class.forName(className).getDeclaredField("MESSAGE").get(null);
        } catch (Exception e) {
            return "Got an error: " + e.getMessage();
        }
    }
}