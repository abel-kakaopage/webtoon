package com.kakao.webtoon.study.adapter.out.repository;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "petshops")
@Getter
@Builder
public class PetShopEntity {
    @Id
    private ObjectId id;
    private String name;
    private List<PetEntity> pets;
}
