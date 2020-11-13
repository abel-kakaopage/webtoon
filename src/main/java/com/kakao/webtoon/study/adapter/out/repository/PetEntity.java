package com.kakao.webtoon.study.adapter.out.repository;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Document(collection = "pets")
@Getter
@Builder
public class PetEntity {

    @Id
    private ObjectId id;
    private ObjectId petShopId;
    private String kind;
    private String name;
    private int age;
    private LocalDateTime created;
}
