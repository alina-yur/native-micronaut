package com.example;

import jakarta.inject.Singleton;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class TranslationRepository {

    private final Map<String, Translation> translations = new ConcurrentHashMap<>();

    public Translation findByEnglish(String english) {
        return translations.get(english);
    }

    public void addTranslation(Translation translation) {
        translations.put(translation.english(), translation);
    }
}
