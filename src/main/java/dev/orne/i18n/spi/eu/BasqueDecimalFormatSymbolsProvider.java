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

import java.text.DecimalFormatSymbols;
import java.text.spi.DecimalFormatSymbolsProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque decimal format symbols provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueDecimalFormatSymbolsProvider
extends DecimalFormatSymbolsProvider {

    /** The character used for thousands separator. */
    public static final char GROUPING_SEPARATOR = '.';
    /** The character used for decimal sign. */
    public static final char DECIMAL_SEPARATOR = ',';
    /** The character used for percent sign. */
    public static final char PERCENT_SYMBOL = '%';
    /** The character used for per mille sign. */
    public static final char PERMILL_SYMBOL = '‰';
    /** The ISO 4217 currency code. */
    public static final String CURRENCY_CODE = "EUR";

    /**
     * {@inheritDoc}
     */
    @Override
    public DecimalFormatSymbols getInstance(
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Basque.LOCALE);
            symbols.setGroupingSeparator(GROUPING_SEPARATOR);
            symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
            symbols.setPercent(PERCENT_SYMBOL);
            symbols.setPerMill(PERMILL_SYMBOL);
            symbols.setInternationalCurrencySymbol(CURRENCY_CODE);
            symbols.setMonetaryDecimalSeparator(DECIMAL_SEPARATOR);
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
