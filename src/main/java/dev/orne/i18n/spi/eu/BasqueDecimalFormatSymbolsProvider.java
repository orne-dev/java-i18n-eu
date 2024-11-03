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
    /** The character used to represent minus sign. */
    public static final char MINUS_SIGN = '−';
    /** The character used for percent sign. */
    public static final char PERCENT_SYMBOL = '%';
    /** The character used for per mille sign. */
    public static final char PERMILL_SYMBOL = '‰';
    /** The ISO 4217 currency code. */
    public static final String CURRENCY_CODE = "EUR";
    /** The ISO 4217 no currency code. */
    public static final String NO_CURRENCY_CODE = "XXX";

    /** The decimal format symbols template. */
    private final DecimalFormatSymbols symbols;
    /** The decimal format symbols template. */
    private final DecimalFormatSymbols symbolsEs;
    /** The decimal format symbols template. */
    private final DecimalFormatSymbols symbolsFr;

    /**
     * Creates a new instance.
     */
    public BasqueDecimalFormatSymbolsProvider() {
        super();
        this.symbols = new DecimalFormatSymbols(Basque.LOCALE);
        this.symbols.setMinusSign(MINUS_SIGN);
        this.symbols.setGroupingSeparator(GROUPING_SEPARATOR);
        this.symbols.setDecimalSeparator(DECIMAL_SEPARATOR);
        this.symbols.setPercent(PERCENT_SYMBOL);
        this.symbols.setPerMill(PERMILL_SYMBOL);
        this.symbols.setInternationalCurrencySymbol(NO_CURRENCY_CODE);
        this.symbols.setMonetaryDecimalSeparator(DECIMAL_SEPARATOR);
        this.symbolsEs = new DecimalFormatSymbols(Basque.LOCALE_ES);
        this.symbolsEs.setMinusSign(MINUS_SIGN);
        this.symbolsEs.setGroupingSeparator(GROUPING_SEPARATOR);
        this.symbolsEs.setDecimalSeparator(DECIMAL_SEPARATOR);
        this.symbolsEs.setPercent(PERCENT_SYMBOL);
        this.symbolsEs.setPerMill(PERMILL_SYMBOL);
        this.symbolsEs.setInternationalCurrencySymbol(CURRENCY_CODE);
        this.symbolsEs.setMonetaryDecimalSeparator(DECIMAL_SEPARATOR);
        this.symbolsFr = new DecimalFormatSymbols(Basque.LOCALE_FR);
        this.symbolsFr.setMinusSign(MINUS_SIGN);
        this.symbolsFr.setGroupingSeparator(GROUPING_SEPARATOR);
        this.symbolsFr.setDecimalSeparator(DECIMAL_SEPARATOR);
        this.symbolsFr.setPercent(PERCENT_SYMBOL);
        this.symbolsFr.setPerMill(PERMILL_SYMBOL);
        this.symbolsFr.setInternationalCurrencySymbol(CURRENCY_CODE);
        this.symbolsFr.setMonetaryDecimalSeparator(DECIMAL_SEPARATOR);
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DecimalFormatSymbols getInstance(
            final @NotNull Locale locale) {
        if (Basque.LOCALE_ES.equals(locale)) {
            return (DecimalFormatSymbols) symbolsEs.clone();
        } else if (Basque.LOCALE_FR.equals(locale)) {
            return (DecimalFormatSymbols) symbolsFr.clone();
        }
        return (DecimalFormatSymbols) symbols.clone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }
}
