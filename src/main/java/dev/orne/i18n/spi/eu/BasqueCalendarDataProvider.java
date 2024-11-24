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

import java.util.Calendar;
import java.util.Locale;
import java.util.spi.CalendarDataProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque calendar data provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueCalendarDataProvider
extends CalendarDataProvider {

    /**
     * Creates a new instance.
     */
    public BasqueCalendarDataProvider() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFirstDayOfWeek(
            final @NotNull Locale locale) {
        if (Basque.LOCALE_ES.equals(locale) ||
                Basque.LOCALE_FR.equals(locale)) {
            return Calendar.MONDAY;
        } else {
            return Calendar.SUNDAY;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMinimalDaysInFirstWeek(
            final @NotNull Locale locale) {
        if (Basque.LOCALE_ES.equals(locale) ||
                Basque.LOCALE_FR.equals(locale)) {
            return 4;
        } else {
            return 1;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }
}
