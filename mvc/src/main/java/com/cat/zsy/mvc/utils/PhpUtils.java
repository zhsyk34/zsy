package com.cat.zsy.mvc.utils;

import de.ailis.pherialize.Pherialize;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class PhpUtils {

    public static List<Long> parse(String s) {
        return Pherialize.unserialize(s).toArray().values().stream().map(o -> (Long) o).collect(toList());
    }
}
