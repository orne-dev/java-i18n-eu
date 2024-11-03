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
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

/**
 * Unit tests for {@code BasqueBreakIteratorProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueBreakIteratorProvider
 */
@Tag("ut")
class BasqueBreakIteratorProviderTest
extends AbstractBasqueProviderTest<BasqueBreakIteratorProvider> {

    /**
     * Creates a new instance.
     */
    BasqueBreakIteratorProviderTest() {
        super(new BasqueBreakIteratorProvider());
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getCharacterInstance(Locale)}.
     */
    @Test
    void testCharacterInstance() {
        assertNotNull(provider.getCharacterInstance(Basque.LOCALE));
        assertNotNull(provider.getCharacterInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getCharacterInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getWordInstance(Locale)}.
     */
    @Test
    void testWordInstance() {
        assertNotNull(provider.getWordInstance(Basque.LOCALE));
        assertNotNull(provider.getWordInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getWordInstance(Basque.LOCALE_FR));
   }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getLineInstance(Locale)}.
     */
    @Test
    void testLineInstance() {
        assertNotNull(provider.getLineInstance(Basque.LOCALE));
        assertNotNull(provider.getLineInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getLineInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getSentenceInstance(Locale)}.
     */
    @Test
    void testSentenceInstance() {
        assertNotNull(provider.getSentenceInstance(Basque.LOCALE));
        assertNotNull(provider.getSentenceInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getSentenceInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getCharacterInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testCharacterInstanceLatestJre() {
        final BreakIterator result = provider.getCharacterInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getCharacterInstance(Basque.LOCALE), result);
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getWordInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testWordInstanceLatestJre() {
        final BreakIterator result = provider.getWordInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getWordInstance(Basque.LOCALE), result);
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getLineInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testLineInstanceLatestJre() {
        final BreakIterator result = provider.getLineInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getLineInstance(Basque.LOCALE), result);
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getSentenceInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testSentenceInstanceLatestJre() {
        final BreakIterator result = provider.getSentenceInstance(Basque.LOCALE);
        assertEquals(BreakIterator.getSentenceInstance(Basque.LOCALE), result);
    }
}
