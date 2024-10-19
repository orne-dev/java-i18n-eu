package dev.orne.i18n.spi.eu;

import static org.junit.jupiter.api.Assertions.*;

import java.text.Collator;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@code BasqueCollatorProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCollatorProvider
 */
@Tag("ut")
class BasqueCollatorProviderTest {

    /** The provider instance to test. */
    private final BasqueCollatorProvider provider = new BasqueCollatorProvider();

    /**
     * Test for {@link BasqueCollatorProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueCollatorProvider#getInstance(Locale)}.
     */
    @Test
    void testCollator() {
        final Collator result = provider.getInstance(Basque.LOCALE);
        assertEquals(Collator.getInstance(new Locale("es")), result);
    }
}
