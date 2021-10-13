package com.example.tomcattest.util.idgenerator;

import java.util.HashMap;
import java.util.Map;

public final class IdGenerator {

    private static Map<Type, Long> CURRENT = new HashMap<>();

    static {
        for (Type type : Type.values()) {
            CURRENT.put(type, null);
        }
    }

    public static long getNext(Type type) {
        long rv = CURRENT.get(type);
        CURRENT.put(type, ++rv);

        return rv;
    }

    private IdGenerator() {

    }
}
