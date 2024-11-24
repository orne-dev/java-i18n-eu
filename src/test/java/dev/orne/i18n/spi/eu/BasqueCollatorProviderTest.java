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

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

/**
 * Unit tests for {@code BasqueCollatorProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCollatorProvider
 */
@Tag("ut")
class BasqueCollatorProviderTest
extends AbstractBasqueProviderTest<BasqueCollatorProvider> {

    /**
     * Creates a new instance.
     */
    BasqueCollatorProviderTest() {
        super(new BasqueCollatorProvider());
    }

    /**
     * Test for {@link BasqueCollatorProvider#getInstance(Locale)}.
     */
    @Test
    void testCollator() {
        assertNotNull(provider.getInstance(Basque.LOCALE));
        assertNotNull(provider.getInstance(Basque.LOCALE_ES));
        assertNotNull(provider.getInstance(Basque.LOCALE_FR));
    }

    /**
     * Test for {@link BasqueCollatorProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testCollatorLatestJre() {
        final RuleBasedCollator expected = assertInstanceOf(
                RuleBasedCollator.class,
                Collator.getInstance(Basque.LOCALE));
        final RuleBasedCollator result = assertInstanceOf(
                RuleBasedCollator.class,
                provider.getInstance(Basque.LOCALE));
        assertEquals(
                expected.getRules(),
                result.getRules());
        assertEquals(
                expected.getDecomposition(),
                result.getDecomposition());
        assertEquals(
                expected.getStrength(),
                result.getStrength());
    }

    /**
     * Test for {@link BasqueCollatorProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testCollatorLatestJreEs() {
        final RuleBasedCollator expected = assertInstanceOf(
                RuleBasedCollator.class,
                Collator.getInstance(Basque.LOCALE_ES));
        final RuleBasedCollator result = assertInstanceOf(
                RuleBasedCollator.class,
                provider.getInstance(Basque.LOCALE_ES));
        assertEquals(
                expected.getRules(),
                result.getRules());
        assertEquals(
                expected.getDecomposition(),
                result.getDecomposition());
        assertEquals(
                expected.getStrength(),
                result.getStrength());
    }

    /**
     * Test for {@link BasqueCollatorProvider#getInstance(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testCollatorLatestJreFr() {
        final RuleBasedCollator expected = assertInstanceOf(
                RuleBasedCollator.class,
                Collator.getInstance(Basque.LOCALE_FR));
        final RuleBasedCollator result = assertInstanceOf(
                RuleBasedCollator.class,
                provider.getInstance(Basque.LOCALE_FR));
        assertEquals(
                expected.getRules(),
                result.getRules());
        assertEquals(
                expected.getDecomposition(),
                result.getDecomposition());
        assertEquals(
                expected.getStrength(),
                result.getStrength());
    }
}
