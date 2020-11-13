package com.kakao.webtoon.study.application.port.out;

import com.kakao.webtoon.study.domain.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface UpdatePetPort {
    void updatePet(Pet pet);
}
