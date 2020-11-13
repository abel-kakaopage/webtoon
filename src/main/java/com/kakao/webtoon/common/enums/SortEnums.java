package com.kakao.webtoon.common.enums;

import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum SortEnums {
    CREATED_DESC(Sort.by("created").descending().and(Sort.by("kind").ascending())),
    CREATED_ASC(Sort.by("created").ascending().and(Sort.by("kind").ascending()));

    private Sort sort;

    SortEnums(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }

    private static final Map<String, SortEnums> ENUM_MAP;

    static {
        Map<String, SortEnums> map = new ConcurrentHashMap<>();
        for (SortEnums instance : SortEnums.values()) {
            map.put(instance.name(), instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static SortEnums get(String name) {
        return ENUM_MAP.get(name);
    }
}
