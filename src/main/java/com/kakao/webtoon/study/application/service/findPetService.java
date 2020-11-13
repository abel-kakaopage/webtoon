package com.kakao.webtoon.study.application.service;

import com.kakao.webtoon.study.application.port.in.FindPetUseCase;
import com.kakao.webtoon.study.application.port.out.FindPetPort;
import com.kakao.webtoon.study.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class findPetService implements FindPetUseCase {

    private final FindPetPort findPetPort;

    @Override
    public Page<Pet> findAllPets(int page, int size, Sort sort) {
        return findPetPort.findAllPets(page, size, sort);
    }
}
