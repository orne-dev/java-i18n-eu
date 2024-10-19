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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyDataExtractor {

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyDataExtractor.class);

    public static void main(String... args) {
        ArrayList<Currency> currencies = new ArrayList<>(Currency.getAvailableCurrencies());
        Collections.sort(currencies, (c1, c2) -> c1.getCurrencyCode().compareTo(c2.getCurrencyCode()));
        HashMap<String, String> names = new HashMap<>();
        HashMap<String, String> symbols = new HashMap<>();
        for (Currency currency : currencies) {
            final String code = currency.getCurrencyCode();
            final String symbol = currency.getSymbol(Locale.ENGLISH);
            final String name = currency.getDisplayName(Locale.ENGLISH);
            LOG.debug("{} : {} ({})", code, symbol, name);
            names.put(code, name);
            symbols.put(code, symbol);
        }
        ArrayList<String> ids = new ArrayList<>(names.keySet());
        Collections.sort(ids);
        LOG.info("### Currencies data ###");
        for (String id : ids) {
            LOG.info("{}={}", id, names.get(id));
            LOG.info("{}.symbol={}", id, symbols.get(id));
        }
    }
}
