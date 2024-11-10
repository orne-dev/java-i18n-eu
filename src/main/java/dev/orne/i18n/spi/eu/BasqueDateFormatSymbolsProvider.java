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

    /** The basque date format symbols template. */
    private static DateFormatSymbols symbols;
    /** The basque (ES) date format symbols template. */
    private static DateFormatSymbols symbolsEs;
    /** The basque (FR) date format symbols template. */
    private static DateFormatSymbols symbolsFr;

    /**
     * Creates a new instance.
     */
    public BasqueDateFormatSymbolsProvider() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateFormatSymbols getInstance(
            final Locale locale) {
        return getSymbols(locale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    static synchronized DateFormatSymbols getSymbols(
            final Locale locale) {
        if (Basque.LOCALE_ES.equals(locale)) {
            if (symbolsEs == null) {
                symbolsEs = new DateFormatSymbols(Basque.LOCALE_ES);
                symbolsEs.setMonths(BasqueCalendarNameProvider.MONTHS_LONG);
                symbolsEs.setShortMonths(BasqueCalendarNameProvider.MONTHS_SHORT);
                symbolsEs.setWeekdays(BasqueCalendarNameProvider.WEEKDAYS_LONG);
                symbolsEs.setShortWeekdays(BasqueCalendarNameProvider.WEEKDAYS_SHORT);
                symbolsEs.setAmPmStrings(BasqueCalendarNameProvider.AMPM_MARKERS);
                symbolsEs.setEras(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT);
                symbolsEs.setZoneStrings(BasqueTimeZoneNameProvider.getNames());
            }
            return (DateFormatSymbols) symbolsEs.clone();
        } else if (Basque.LOCALE_FR.equals(locale)) {
            if (symbolsFr == null) {
                symbolsFr = new DateFormatSymbols(Basque.LOCALE_FR);
                symbolsFr.setMonths(BasqueCalendarNameProvider.MONTHS_LONG);
                symbolsFr.setShortMonths(BasqueCalendarNameProvider.MONTHS_SHORT);
                symbolsFr.setWeekdays(BasqueCalendarNameProvider.WEEKDAYS_LONG);
                symbolsFr.setShortWeekdays(BasqueCalendarNameProvider.WEEKDAYS_SHORT);
                symbolsFr.setAmPmStrings(BasqueCalendarNameProvider.AMPM_MARKERS);
                symbolsFr.setEras(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT);
                symbolsFr.setZoneStrings(BasqueTimeZoneNameProvider.getNames());
            }
            return (DateFormatSymbols) symbolsFr.clone();
        } else {
            if (symbols == null) {
                symbols = new DateFormatSymbols(Basque.LOCALE);
                symbols.setMonths(BasqueCalendarNameProvider.MONTHS_LONG);
                symbols.setShortMonths(BasqueCalendarNameProvider.MONTHS_SHORT);
                symbols.setWeekdays(BasqueCalendarNameProvider.WEEKDAYS_LONG);
                symbols.setShortWeekdays(BasqueCalendarNameProvider.WEEKDAYS_SHORT);
                symbols.setAmPmStrings(BasqueCalendarNameProvider.AMPM_MARKERS);
                symbols.setEras(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT);
                symbols.setZoneStrings(BasqueTimeZoneNameProvider.getNames());
            }
            return (DateFormatSymbols) symbols.clone();
        }
    }
}
