package com.kakao.webtoon.study.application.port.out;

import com.kakao.webtoon.study.domain.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface FindPetPort {
    Page<Pet> findAllPets(int page, int size, Sort sort);
    Pet findPet(ObjectId id);
}
