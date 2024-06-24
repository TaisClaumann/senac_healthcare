package com.backend_senac.healthcare.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class MessageBundle {

    public static String getMessage(String key) {
        MessageSource messageSource = ApplicationContextProvider.getApplicationContext().getBean(MessageSource.class);
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String key, Object... args) {
        MessageSource messageSource = ApplicationContextProvider.getApplicationContext().getBean(MessageSource.class);
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String key, Locale locale, Object... args) {
        MessageSource messageSource = ApplicationContextProvider.getApplicationContext().getBean(MessageSource.class);
        return messageSource.getMessage(key, args, locale);
    }
}
