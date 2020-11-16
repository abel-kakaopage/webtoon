package com.kakao.webtoon.pet.application.service;

import com.kakao.webtoon.pet.application.port.in.BuyPetUseCase;
import com.kakao.webtoon.pet.application.port.out.FindPetPort;
import com.kakao.webtoon.pet.application.port.out.FindPetShopPort;
import com.kakao.webtoon.pet.application.port.out.UpdatePetPort;
import com.kakao.webtoon.pet.application.port.out.UpdatePetShopPort;
import com.kakao.webtoon.pet.domain.Pet;
import com.kakao.webtoon.pet.domain.PetShop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuyPetService implements BuyPetUseCase {

    private final FindPetPort findPetPort;
    private final FindPetShopPort findPetShopPort;
    private final UpdatePetPort updatePetPort;
    private final UpdatePetShopPort updatePetShopPort;

    @Override
    @Transactional
    public boolean buyPet(ObjectId petId, ObjectId petShopId) {

        Pet pet = findPetPort.findPet(petId);
        pet.setOwner(petShopId);
        updatePetPort.updatePet(pet);
        PetShop petShop = findPetShopPort.findPetShop(petShopId);
        petShop.buyPet(pet);
        updatePetShopPort.updatePetShop(petShop);
        log.info("펫샵이 업데이트 되었다.");
        return true;
    }
}
