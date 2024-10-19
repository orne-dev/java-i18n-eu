package dev.orne.i18n.spi.eu;

import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque locale service provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueLocaleServiceProvider
extends LocaleServiceProvider {

    /** The basque locales. */
    static final Locale[] LOCALES = new Locale[] { Basque.LOCALE, Basque.LOCALE_ES, Basque.LOCALE_FR };

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return LOCALES;
    }
}
