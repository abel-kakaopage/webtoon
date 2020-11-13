package com.kakao.webtoon.study.application.port.in;

import com.kakao.webtoon.study.domain.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface FindPetUseCase {
    Page<Pet> findAllPets(int page, int size, Sort sort);
}
