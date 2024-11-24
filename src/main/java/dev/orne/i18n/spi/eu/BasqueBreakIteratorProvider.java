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

import java.text.BreakIterator;
import java.text.spi.BreakIteratorProvider;
import java.util.Locale;

import javax.validation.constraints.NotNull;

/**
 * Basque break iterator provider.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public class BasqueBreakIteratorProvider
extends BreakIteratorProvider {

    /**
     * Creates a new instance.
     */
    public BasqueBreakIteratorProvider() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getWordInstance(
            final @NotNull Locale locale) {
        return BreakIterator.getWordInstance(Locale.ENGLISH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getLineInstance(
            final @NotNull Locale locale) {
        return BreakIterator.getLineInstance(Locale.ENGLISH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getCharacterInstance(
            final @NotNull Locale locale) {
        return BreakIterator.getCharacterInstance(Locale.ENGLISH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BreakIterator getSentenceInstance(
            final @NotNull Locale locale) {
        return BreakIterator.getSentenceInstance(Locale.ENGLISH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Locale[] getAvailableLocales() {
        return BasqueLocaleServiceProvider.LOCALES;
    }
}
