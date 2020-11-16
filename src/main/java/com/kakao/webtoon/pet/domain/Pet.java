package com.kakao.webtoon.pet.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pet {
    @Getter
    private ObjectId id;
    @Getter
    private ObjectId petShopId;
    @Getter
    private String kind;
    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    private LocalDateTime created;

    public void setOwner(ObjectId petShopId) {
        this.petShopId = petShopId;
    }
}
