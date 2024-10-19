package dev.orne.i18n.spi.eu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque date format provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueDateFormatProvider
extends DateFormatProvider {

    /** Time formats.  */
    static final String[] TIME_FORMATS = new String[] {
            "HH:mm:ss zzzz",
            "HH:mm:ss z",
            "HH:mm:ss",
            "HH:mm"
    };
    /** Date formats.  */
    static final String[] DATE_FORMATS = new String[] {
            "EEEE, yyyy'ko' MMMM'ren' d'a'",
            "yyyy'ko' MMMM'ren' d'a'",
            "yyyy/MM/dd",
            "yy/MM/dd"
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat getDateInstance(
            final int style,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new SimpleDateFormat(getDateFormat(style), locale);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat getTimeInstance(
            final int style,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new SimpleDateFormat(getTimeFormat(style), locale);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormat getDateTimeInstance(
            final int dateStyle,
            final int timeStyle,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return new SimpleDateFormat(
                    getDateFormat(dateStyle) + " " + getTimeFormat(timeStyle),
                    locale);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    /**
     * Returns the date format for the specified style.
     * 
     * @param style The date style.
     * @return The date format.
     */
    public static @NotNull String getDateFormat(
            int style) {
        if (style >= DATE_FORMATS.length) {
            style = DateFormat.SHORT;
        }
        return DATE_FORMATS[style];
    }

    /**
     * Returns the time format for the specified style.
     * 
     * @param style The time style.
     * @return The time format.
     */
    public static @NotNull String getTimeFormat(
            int style) {
        if (style >= TIME_FORMATS.length) {
            style = DateFormat.SHORT;
        }
        return TIME_FORMATS[style];
    }
}
