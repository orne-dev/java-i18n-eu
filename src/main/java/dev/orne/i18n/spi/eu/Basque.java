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

import java.util.Locale;

/**
 * Constants for basque language.
 * 
 * @author <a href="https://github.com/ihernaez">(w) Iker Hernaez</a>
 * @version 1.0, 2024-10
 * @since 1.0
 */
public final class Basque {

    /** The basque language ISO 639 code. */
    public static final String LANGUAGE = "eu";
    /** The basque language locale. */
    public static final Locale LOCALE = new Locale(LANGUAGE);
    /** The southern basque country locale. */
    public static final Locale LOCALE_ES = new Locale(LANGUAGE, "ES");
    /** The northern basque country locale. */
    public static final Locale LOCALE_FR = new Locale(LANGUAGE, "FR");

    /**
     * Private constructor.
     */
    private Basque() {
        // Utility class
    }
}
