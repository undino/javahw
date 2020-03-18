package org.itstep.formatter;

import lombok.extern.slf4j.Slf4j;
import org.itstep.enums.IsWarden;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class EnumWardenFormatter implements Formatter<IsWarden> {

    @Override
    public IsWarden parse(String s, Locale locale) throws ParseException {
        log.info("in to Formatter, s = " + s);
            return IsWarden.IS_WARDEN;
    }

    @Override
    public String print(IsWarden isWarden, Locale locale) {
        return String.valueOf(isWarden);
    }
}
