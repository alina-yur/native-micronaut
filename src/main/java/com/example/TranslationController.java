package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.util.Optional;

@Controller
public class TranslationController {

    private final TranslationRepository translationRepository;

    public TranslationController(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;

        translationRepository.addTranslation(new Translation("Hello", "Grüezi"));
        translationRepository.addTranslation(new Translation("Thank you", "Merci vielmal"));
    }

    @Get("/translate")
    public String translate(@QueryValue Optional<String> english) {
        return english.map(translationRepository::findByEnglish)
                .map(Translation::german)
                .orElse("No translation found");
    }
}
