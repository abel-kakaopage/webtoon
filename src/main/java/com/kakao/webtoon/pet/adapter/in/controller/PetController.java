package com.kakao.webtoon.pet.adapter.in.controller;

import com.kakao.webtoon.common.enums.SortEnums;
import com.kakao.webtoon.pet.application.port.in.BuyPetUseCase;
import com.kakao.webtoon.pet.application.port.in.FindPetUseCase;
import com.kakao.webtoon.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pet")
class PetController {

    private final FindPetUseCase findPetUseCase;
    private final BuyPetUseCase buyPetUseCase;

    @GetMapping(path = "/list")
    public Page<Pet> findAllPets(
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "size", required = false, defaultValue = "2") int size,
            @RequestParam(value = "sort", required = false, defaultValue = "CREATED_DESC") String sort) {

        return findPetUseCase.findAllPets(page, size, SortEnums.get(sort).getSort());
    }

    @PostMapping(path = "/buy")
    public boolean buyPets(
            @RequestParam(value = "shopId") String shopId,
            @RequestParam(value = "petId") String petId) {
        return buyPetUseCase.buyPet(new ObjectId(petId), new ObjectId(shopId));
    }
}
