package dev.orne.i18n.spi.eu;

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
