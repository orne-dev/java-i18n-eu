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
import java.util.spi.LocaleNameProvider;

import javax.validation.constraints.NotNull;

/**
 * Basque locale name provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueLocaleNameProvider
extends LocaleNameProvider {

    /** The logger of the class. */
    private static final Logger LOG = Logger.getLogger(BasqueLocaleNameProvider.class.getName());

    /** Language name property prefix. */
    static final String LANGUAGE_PREFIX = "language.";
    /** Country name property prefix. */
    static final String COUNTRY_PREFIX = "country.";
    /** Variant name property prefix. */
    static final String VARIANT_PREFIX = "variant.";
    /** Script name property prefix. */
    static final String SCRIPT_PREFIX = "script.";

    /** The locale display names. */
    private static Properties data;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayLanguage(
            final @NotNull String languageCode,
            final @NotNull Locale locale) {
        return getData().getProperty(LANGUAGE_PREFIX + languageCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayCountry(
            final @NotNull String countryCode,
            final @NotNull Locale locale) {
        return getData().getProperty(COUNTRY_PREFIX + countryCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayVariant(
            final @NotNull String variant,
            final @NotNull Locale locale) {
        return getData().getProperty(VARIANT_PREFIX + variant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDisplayScript(
            final String scriptCode,
            final Locale locale) {
        return getData().getProperty(SCRIPT_PREFIX + scriptCode);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }

    /**
     * Returns the locale names data.
     * 
     * @return The locale names.
     */
    static synchronized @NotNull Properties getData() {
        if (data == null) {
            data = new Properties();
            try (InputStream is = BasqueLocaleNameProvider.class.getResourceAsStream("locale.properties")) {
                data.load(is);
            } catch (final IOException e) {
                LOG.log(Level.SEVERE, "Error loading basque locale names", e);
            }
        }
        return data;
    }
}
