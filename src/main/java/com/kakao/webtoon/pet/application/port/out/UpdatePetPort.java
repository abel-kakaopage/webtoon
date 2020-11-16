package com.kakao.webtoon.pet.application.port.out;

import com.kakao.webtoon.pet.domain.Pet;

public interface UpdatePetPort {
    void updatePet(Pet pet);
}
