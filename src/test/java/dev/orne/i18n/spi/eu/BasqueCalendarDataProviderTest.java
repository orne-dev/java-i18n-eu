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
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

/**
 * Unit tests for {@code BasqueCalendarDataProvider}.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 * @see BasqueCalendarDataProvider
 */
@Tag("ut")
class BasqueCalendarDataProviderTest
extends AbstractBasqueProviderTest<BasqueCalendarDataProvider> {

    /**
     * Creates a new instance.
     */
    BasqueCalendarDataProviderTest() {
        super(new BasqueCalendarDataProvider());
    }

    /**
     * Test for {@link BasqueCalendarDataProvider#getFirstDayOfWeek(Locale)}.
     */
    @Test
    void testGetFirstDayOfWeek() {
        assertEquals(Calendar.MONDAY, provider.getFirstDayOfWeek(Basque.LOCALE_ES));
        assertEquals(Calendar.MONDAY, provider.getFirstDayOfWeek(Basque.LOCALE_FR));
        assertEquals(Calendar.SUNDAY, provider.getFirstDayOfWeek(Basque.LOCALE));
    }

    /**
     * Test for {@link BasqueCalendarDataProvider#getMinimalDaysInFirstWeek(Locale)}.
     */
    @Test
    void testGetMinimalDaysInFirstWeek() {
        assertEquals(4, provider.getMinimalDaysInFirstWeek(Basque.LOCALE_ES));
        assertEquals(4, provider.getMinimalDaysInFirstWeek(Basque.LOCALE_FR));
        assertEquals(1, provider.getMinimalDaysInFirstWeek(Basque.LOCALE));
    }

    /**
     * Test for {@link BasqueCalendarDataProvider#getFirstDayOfWeek(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetFirstDayOfWeekLatestCldr() {
        assertEquals(
                Calendar.getInstance(Basque.LOCALE_ES).getFirstDayOfWeek(),
                provider.getFirstDayOfWeek(Basque.LOCALE_ES));
        assertEquals(
                Calendar.getInstance(Basque.LOCALE_FR).getFirstDayOfWeek(),
                provider.getFirstDayOfWeek(Basque.LOCALE_FR));
        assertEquals(
                Calendar.getInstance(Basque.LOCALE).getFirstDayOfWeek(),
                provider.getFirstDayOfWeek(Basque.LOCALE));
    }

    /**
     * Test for {@link BasqueCalendarDataProvider#getMinimalDaysInFirstWeek(Locale)}.
     */
    @EnabledForJreRange(min = JRE.JAVA_21,
            disabledReason = "JRE > 21 test")
    @Test
    void testGetMinimalDaysInFirstWeekLatestCldr() {
        assertEquals(
                Calendar.getInstance(Basque.LOCALE_ES).getMinimalDaysInFirstWeek(),
                provider.getMinimalDaysInFirstWeek(Basque.LOCALE_ES));
        assertEquals(
                Calendar.getInstance(Basque.LOCALE_FR).getMinimalDaysInFirstWeek(),
                provider.getMinimalDaysInFirstWeek(Basque.LOCALE_FR));
        assertEquals(
                Calendar.getInstance(Basque.LOCALE).getMinimalDaysInFirstWeek(),
                provider.getMinimalDaysInFirstWeek(Basque.LOCALE));
    }
}
