package com.example.springbootsample.applicationService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    
    @Autowired
    private MessageSource messageSource;

    /**
     * 性別のMapを生成する
     * @return　genderMap 性別のマップ
     */
    public Map<String, Integer> getGenderMap(Locale locale) {
        Map<String, Integer> genderMap = new LinkedHashMap<>();
        String male = messageSource.getMessage("male", null, locale);
        String female = messageSource.getMessage("female", null,locale);
        genderMap.put(male, 1);
        genderMap.put(female, 2);
        return genderMap;
    }
}
