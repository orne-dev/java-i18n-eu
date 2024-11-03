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
    private final DateFormatSymbols symbols;
    /** The basque (ES) date format symbols template. */
    private final DateFormatSymbols symbolsEs;
    /** The basque (FR) date format symbols template. */
    private final DateFormatSymbols symbolsFr;

    /**
     * Creates a new instance.
     */
    public BasqueDateFormatSymbolsProvider() {
        this.symbols = new DateFormatSymbols(Basque.LOCALE);
        this.symbols.setMonths(BasqueCalendarNameProvider.MONTHS_LONG);
        this.symbols.setShortMonths(BasqueCalendarNameProvider.MONTHS_SHORT);
        this.symbols.setWeekdays(BasqueCalendarNameProvider.WEEKDAYS_LONG);
        this.symbols.setShortWeekdays(BasqueCalendarNameProvider.WEEKDAYS_SHORT);
        this.symbols.setAmPmStrings(BasqueCalendarNameProvider.AMPM_MARKERS);
        this.symbols.setEras(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT);
        this.symbols.setZoneStrings(BasqueTimeZoneNameProvider.getNames());
        this.symbolsEs = new DateFormatSymbols(Basque.LOCALE_ES);
        this.symbolsEs.setMonths(BasqueCalendarNameProvider.MONTHS_LONG);
        this.symbolsEs.setShortMonths(BasqueCalendarNameProvider.MONTHS_SHORT);
        this.symbolsEs.setWeekdays(BasqueCalendarNameProvider.WEEKDAYS_LONG);
        this.symbolsEs.setShortWeekdays(BasqueCalendarNameProvider.WEEKDAYS_SHORT);
        this.symbolsEs.setAmPmStrings(BasqueCalendarNameProvider.AMPM_MARKERS);
        this.symbolsEs.setEras(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT);
        this.symbolsEs.setZoneStrings(BasqueTimeZoneNameProvider.getNames());
        this.symbolsFr = new DateFormatSymbols(Basque.LOCALE_FR);
        this.symbolsFr.setMonths(BasqueCalendarNameProvider.MONTHS_LONG);
        this.symbolsFr.setShortMonths(BasqueCalendarNameProvider.MONTHS_SHORT);
        this.symbolsFr.setWeekdays(BasqueCalendarNameProvider.WEEKDAYS_LONG);
        this.symbolsFr.setShortWeekdays(BasqueCalendarNameProvider.WEEKDAYS_SHORT);
        this.symbolsFr.setAmPmStrings(BasqueCalendarNameProvider.AMPM_MARKERS);
        this.symbolsFr.setEras(BasqueCalendarNameProvider.GREGORIAN_ERAS_SHORT);
        this.symbolsFr.setZoneStrings(BasqueTimeZoneNameProvider.getNames());
    }

    /**
     * {@inheritDoc}
     */
    @Override
	public DateFormatSymbols getInstance(
	        final Locale locale) {
        if (Basque.LOCALE_ES.equals(locale)) {
            return (DateFormatSymbols) symbolsEs.clone();
        } else if (Basque.LOCALE_ES.equals(locale)) {
            return (DateFormatSymbols) symbolsFr.clone();
        } else {
            return (DateFormatSymbols) symbols.clone();
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
