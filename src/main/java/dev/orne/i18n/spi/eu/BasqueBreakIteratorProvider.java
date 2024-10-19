package dev.orne.i18n.spi.eu;

import java.text.BreakIterator;
import java.text.spi.BreakIteratorProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque break iterator provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueBreakIteratorProvider
extends BreakIteratorProvider {

    /** Spanish language locale. */
    private static final Locale SPANISH = new Locale("es");

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getWordInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return BreakIterator.getWordInstance(SPANISH);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getLineInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return BreakIterator.getLineInstance(SPANISH);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getCharacterInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return BreakIterator.getCharacterInstance(SPANISH);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getSentenceInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return BreakIterator.getSentenceInstance(SPANISH);
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
