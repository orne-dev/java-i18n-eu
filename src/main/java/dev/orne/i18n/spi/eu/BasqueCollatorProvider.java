package dev.orne.i18n.spi.eu;

import java.text.Collator;
import java.text.spi.CollatorProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque collator provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueCollatorProvider
extends CollatorProvider {

    /** Spanish language locale. */
    private static final Locale SPANISH = new Locale("es");

    /**
     * {@inheritDoc}
     */
    @Override
    public Collator getInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return Collator.getInstance(SPANISH);
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
}
