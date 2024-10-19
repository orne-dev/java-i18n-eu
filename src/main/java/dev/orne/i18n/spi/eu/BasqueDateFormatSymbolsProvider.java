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

    /** Day names. */
    static final String[] WEEKDAY_NAMES = new String[] {
            "igandea",
            "astelehena",
            "asteartea",
            "asteazkena",
            "osteguna",
            "ostirala",
            "larunbata",
            ""
    };
    /** Short day names. */
    static final String[] SHORT_WEEKDAY_NAMES = new String[] {
            "iga",
            "ale",
            "ast",
            "azk",
            "oeg",
            "oir",
            "lar",
            ""
    };
    /** Narrow day names. */
    static final String[] NARROW_DAY_NAMES = new String[] {
            "IG",
            "AL",
            "AS",
            "AZ",
            "OG",
            "OR",
            "LR",
            ""
    };
    /** Month names. */
    static final String[] MONTH_NAMES = new String[] {
            "urtarrila",
            "otsaila",
            "martxoa",
            "apirila",
            "maiatza",
            "ekaina",
            "uztaila",
            "abuztua",
            "iraila",
            "urria",
            "azaroa",
            "abendua",
            ""
    };
    /** Short month names. */
    static final String[] SHORT_MONTH_NAMES = new String[] {
            "urt",
            "ots",
            "mar",
            "api",
            "mai",
            "eka",
            "uzt",
            "abu",
            "ira",
            "urr",
            "aza",
            "abe",
            ""
    };
    /** Narrow month names. */
    static final String[] NARROW_MONTH_NAMES = new String[] {
            "U",
            "O",
            "M",
            "A",
            "M",
            "E",
            "U",
            "A",
            "I",
            "U",
            "A",
            "A",
            ""
    };
    /** Calendar quarter names. */
    static final String[] QUARTER_NAMES = new String[] {
            "1go hiruhilabetea",
            "2en hiruhilabetea",
            "3en hiruhilabetea",
            "4en hiruhilabetea",
            ""
    };
    /** Short calendar quarter names. */
    static final String[] SHORT_QUARTER_NAMES = new String[] {
            "1H",
            "2H",
            "3H",
            "4H",
            ""
    };
    /** Narrow calendar quarter names. */
    static final String[] NARROW_QUARTER_NAMES = new String[] {
            "1H",
            "2H",
            "3H",
            "4H",
            ""
    };
    /** AM-PM markers. */
    static final String[] AMPM_MARKERS = new String[] {
            "a.m.",
            "p.m.",
            ""
    };
    /** Era names. */
    static final String[] ERA_NAMES = new String[] {
            "Kristo aurretik",
            "Kristo ondoren",
            ""
    };
    /** Short era names. */
    static final String[] SHORT_ERA_NAMES = new String[] {
            "K.a.",
            "K.o.",
            ""
    };

    /**
     * {@inheritDoc}
     */
    @Override
	public DateFormatSymbols getInstance(Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            final DateFormatSymbols symbols = new DateFormatSymbols(Basque.LOCALE);
            symbols.setMonths(MONTH_NAMES);
            symbols.setShortMonths(SHORT_MONTH_NAMES);
            symbols.setWeekdays(WEEKDAY_NAMES);
            symbols.setShortWeekdays(SHORT_WEEKDAY_NAMES);
            symbols.setAmPmStrings(AMPM_MARKERS);
            symbols.setEras(SHORT_ERA_NAMES);
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
