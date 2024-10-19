package dev.orne.i18n.spi.eu;

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
