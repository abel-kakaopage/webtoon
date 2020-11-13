package com.kakao.webtoon.study.application.service;

import com.kakao.webtoon.study.application.port.in.BuyPetUseCase;
import com.kakao.webtoon.study.application.port.out.FindPetPort;
import com.kakao.webtoon.study.application.port.out.FindPetShopPort;
import com.kakao.webtoon.study.application.port.out.UpdatePetPort;
import com.kakao.webtoon.study.application.port.out.UpdatePetShopPort;
import com.kakao.webtoon.study.domain.Events;
import com.kakao.webtoon.study.domain.Pet;
import com.kakao.webtoon.study.domain.PetShop;
import com.kakao.webtoon.study.domain.PetShopBuyedEvent;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

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
        Events.raise(new PetShopBuyedEvent());
        try {
            System.out.println("Sleep 2 seconds");
            Thread.sleep(2000L); // 이벤트 발생후 2초 슬립
        } catch (InterruptedException e) {

        }
        Pet pet = findPetPort.findPet(petId);
        pet.setOwner(petShopId);
        updatePetPort.updatePet(pet);
        PetShop petShop = findPetShopPort.findPetShop(petShopId);
        petShop.buyPet(pet);
        updatePetShopPort.updatePetShop(petShop);
        return true;
    }
}
