package ru.daleshin.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

import java.util.Locale;

@ConfigurationProperties(prefix = "question")
@Data
public class YamlProps {

	private String filenameEn;
    private String filenameRu;
    private int numberOfCorrectAnswers;
    private Locale locale;

}
