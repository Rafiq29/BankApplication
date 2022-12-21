package com.herb.bankapp.config;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleConfiguration {
    public static String getMessage(String key) {
        Locale locale = LocaleContextHolder.getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle("language/messages", locale);
        return bundle.getString(key);
    }
}
