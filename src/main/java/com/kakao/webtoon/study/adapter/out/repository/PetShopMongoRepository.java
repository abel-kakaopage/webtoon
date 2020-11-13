package com.kakao.webtoon.study.adapter.out.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetShopMongoRepository extends MongoRepository<PetShopEntity, ObjectId> {
}
