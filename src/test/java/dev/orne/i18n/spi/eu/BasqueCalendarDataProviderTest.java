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

import java.util.Calendar;
import java.util.Locale;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@code BasqueCalendarDataProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCalendarDataProvider
 */
@Tag("ut")
class BasqueCalendarDataProviderTest {

    /** The provider instance to test. */
    private final BasqueCalendarDataProvider provider = new BasqueCalendarDataProvider();

    /**
     * Test for {@link BasqueCalendarDataProvider#getFirstDayOfWeek(Locale)}.
     */
    @Test
    void testGetFirstDayOfWeek() {
        assertEquals(Calendar.MONDAY, provider.getFirstDayOfWeek(Basque.LOCALE));
    }

    /**
     * Test for {@link BasqueCalendarDataProvider#getMinimalDaysInFirstWeek(Locale)}.
     */
    @Test
    void testGetMinimalDaysInFirstWeek() {
        assertEquals(0, provider.getMinimalDaysInFirstWeek(Basque.LOCALE));
    }

    /**
     * Test for {@link BasqueCalendarDataProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
        assertFalse(provider.isSupportedLocale(Locale.FRENCH));
        assertFalse(provider.isSupportedLocale(Locale.FRANCE));
        assertFalse(provider.isSupportedLocale(new Locale("es")));
        assertFalse(provider.isSupportedLocale(new Locale("es", "ES")));
    }
}
