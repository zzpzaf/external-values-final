package com.zzpzaf.se.devxperiences.posts.externalvalues.Properties;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;

public class CustomLocaleResolver extends AcceptHeaderLocaleResolver {

    private Locale[] acceptableLocals = {Locale.GERMANY, Locale.FRANCE, Locale.ENGLISH, Locale.US, Locale.forLanguageTag("el-GR") };

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String langHeader = request.getHeader("Accept-Language");
        if (langHeader.trim().isEmpty()) {
            return Locale.US;           //we use it as 'default' locale
        }
        List<Locale.LanguageRange> listRangePassedIn = Locale.LanguageRange.parse(langHeader);
        Locale selectedLocale = Locale.lookup(listRangePassedIn,Arrays.asList(acceptableLocals));
        
        return selectedLocale;
     }
    
}
