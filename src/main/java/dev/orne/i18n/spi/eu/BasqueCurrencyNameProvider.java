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
    static final String SYMBOL_SUFFIX = ".symbol";
    /** The currency names. */
    private Properties currencies;

    /**
     * Creates a new instance.
     */
    public BasqueCurrencyNameProvider() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSymbol(
            final @NotNull String currencyCode,
            final @NotNull Locale locale) {
        return getCurrencies().getProperty(currencyCode + SYMBOL_SUFFIX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayName(
            final @NotNull String currencyCode,
            final @NotNull Locale locale) {
        return getCurrencies().getProperty(currencyCode);
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
