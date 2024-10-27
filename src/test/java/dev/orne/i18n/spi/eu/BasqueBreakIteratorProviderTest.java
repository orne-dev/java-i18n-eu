package dev.orne.i18n.spi.eu;

/*-
 * #%L
 * basque-locale-extension
 * %%
 * Copyright (C) 2024 Orne Developments
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import static org.junit.jupiter.api.Assertions.*;

import java.text.BreakIterator;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@code BasqueBreakIteratorProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueBreakIteratorProvider
 */
@Tag("ut")
class BasqueBreakIteratorProviderTest {

    private static final Locale SPANISH = new Locale("es");

    /** The provider instance to test. */
    private final BasqueBreakIteratorProvider provider = new BasqueBreakIteratorProvider();

    /**
     * Test for {@link BasqueBreakIteratorProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getCharacterInstance(Locale)}.
     */
    @Test
    void testCharacterInstance() {
        final BreakIterator result = provider.getCharacterInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getCharacterInstance(SPANISH), result);
        assertNull(provider.getCharacterInstance(SPANISH));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getWordInstance(Locale)}.
     */
    @Test
    void testWordInstance() {
        final BreakIterator result = provider.getWordInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getWordInstance(SPANISH), result);
        assertNull(provider.getWordInstance(SPANISH));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getLineInstance(Locale)}.
     */
    @Test
    void testLineInstance() {
        final BreakIterator result = provider.getLineInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getLineInstance(SPANISH), result);
        assertNull(provider.getLineInstance(SPANISH));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getSentenceInstance(Locale)}.
     */
    @Test
    void testSentenceInstance() {
        final BreakIterator result = provider.getSentenceInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getSentenceInstance(SPANISH), result);
        assertNull(provider.getSentenceInstance(SPANISH));
    }
}
