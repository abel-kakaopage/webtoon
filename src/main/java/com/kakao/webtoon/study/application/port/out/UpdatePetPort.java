package com.kakao.webtoon.study.application.port.out;

import com.kakao.webtoon.study.domain.Pet;

public interface UpdatePetPort {
    void updatePet(Pet pet);
}
