package com.kakao.webtoon.pet.adapter.out.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PetMongoRepository extends MongoRepository<PetEntity, ObjectId> {
    Optional<PetEntity> findByName(String name);
}
