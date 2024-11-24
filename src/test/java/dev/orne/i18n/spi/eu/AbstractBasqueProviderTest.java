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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.spi.LocaleServiceProvider;

import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Test;

/**
 * Base abstract unit tests for basque locale service providers.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-11
 * @since 1.0
 */
class AbstractBasqueProviderTest<T extends LocaleServiceProvider> {

    /** The basque locale service provider. */
    protected final @NotNull T provider;

    /**
     * Creates a new instance.
     * 
     * @param provider The basque locale service provider.
     */
    protected AbstractBasqueProviderTest(
            final @NotNull T provider) {
        super();
        this.provider = provider;
    }

    /**
     * Returns the basque locale service provider.
     * 
     * @return The basque locale service provider.
     */
    public @NotNull T getProvider() {
        return this.provider;
    }

    /**
     * Test for {@link BasqueBreakIteratorProvider#getAvailableLocales()}.
     */
    @Test
    void testAvailableLocales() {
        assertTrue(provider.isSupportedLocale(Basque.LOCALE));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_ES));
        assertTrue(provider.isSupportedLocale(Basque.LOCALE_FR));
    }
}
