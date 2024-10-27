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

import java.text.DateFormatSymbols;
import java.text.spi.DateFormatSymbolsProvider;
import java.util.Arrays;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque date format symbols provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueDateFormatSymbolsProvider
extends DateFormatSymbolsProvider {

    /**
     * {@inheritDoc}
     */
    @Override
	public DateFormatSymbols getInstance(Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            final DateFormatSymbols symbols = new DateFormatSymbols(Basque.LOCALE);
            symbols.setMonths(Arrays.copyOf(
                    BasqueCalendarNameProvider.MONTHS_LONG,
                    BasqueCalendarNameProvider.MONTHS_LONG.length));
            symbols.setShortMonths(Arrays.copyOf(
                    BasqueCalendarNameProvider.MONTHS_SHORT,
                    BasqueCalendarNameProvider.MONTHS_SHORT.length));
            symbols.setWeekdays(Arrays.copyOf(
                    BasqueCalendarNameProvider.WEEKDAYS_LONG,
                    BasqueCalendarNameProvider.WEEKDAYS_LONG.length));
            symbols.setShortWeekdays(Arrays.copyOf(
                    BasqueCalendarNameProvider.WEEKDAYS_SHORT,
                    BasqueCalendarNameProvider.WEEKDAYS_SHORT.length));
            symbols.setAmPmStrings(Arrays.copyOf(
                    BasqueCalendarNameProvider.AMPM_MARKERS,
                    BasqueCalendarNameProvider.AMPM_MARKERS.length));
            symbols.setEras(Arrays.copyOf(
                    BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT,
                    BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT.length));
            symbols.setZoneStrings(null);
            return symbols;
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
