package dev.orne.i18n.spi.eu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.spi.CurrencyNameProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque currency names provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueCurrencyNameProvider
extends CurrencyNameProvider {

    /** The logger of the class. */
    private static final Logger LOG = Logger.getLogger(BasqueCurrencyNameProvider.class.getName());

    /** Suffix for currency symbol properties. */
    private static final String SYMBOL_SUFFIX = ".symbol";
    /** The currency names. */
    private Properties currencies;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSymbol(
            final @NotNull String currencyCode,
            final @NotNull Locale locale) {
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            return getCurrencies().getProperty(currencyCode + SYMBOL_SUFFIX);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayName(
            final @NotNull String currencyCode,
            final @NotNull Locale locale) {
        String name = null;
        if (Basque.LANGUAGE.equals(locale.getLanguage())) {
            name = getCurrencies().getProperty(currencyCode);
        }
        if (name == null) {
            name = super.getDisplayName(currencyCode, locale);
        }
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    /**
     * Returns the currency names for ISO 4217 currency codes.
     * 
     * @return The currency names.
     */
    synchronized @NotNull Properties getCurrencies() {
        if (currencies == null) {
            currencies = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("currencies.properties")) {
                currencies.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque currency names", e);
            }
        }
        return currencies;
    }
}
