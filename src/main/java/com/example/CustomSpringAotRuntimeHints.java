package com.example;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(CustomSpringAotRuntimeHints.CustomRuntimeHintsRegistrar.class)
@Configuration
public class CustomSpringAotRuntimeHints {
    
    // To register these classes into AOT when they are otherwise unable to be dynamically discovered.
    static class CustomRuntimeHintsRegistrar implements RuntimeHintsRegistrar {
        @SuppressWarnings("null")
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection().registerType(HttpServiceController.class);
            try {
                hints.reflection().registerType(
                    TypeReference.of("ch.qos.logback.core.ConsoleAppender"),
                        builder -> builder.withMembers(MemberCategory.values() )
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
