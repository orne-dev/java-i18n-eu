package dev.orne.i18n.spi.eu;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.spi.LocaleServiceProvider;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Test;

/**
 * Base abstract unit tests for basque locale service providers.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-11
 * @since 1.0
 */
class AbstractBasqueProviderTest<T extends LocaleServiceProvider> {

    /** The basque locale service provider. */
    protected final @NotNull T provider;

    /**
     * Creates a new instance.
     * 
     * @param provider The basque locale service provider.
     */
    protected AbstractBasqueProviderTest(
            final @NotNull T provider) {
        super();
        this.provider = provider;
    }

    /**
     * Returns the basque locale service provider.
     * 
     * @return The basque locale service provider.
     */
    public @NotNull T getProvider() {
        return this.provider;
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
    }
}
