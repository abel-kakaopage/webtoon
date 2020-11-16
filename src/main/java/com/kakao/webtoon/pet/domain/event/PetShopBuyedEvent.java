package com.kakao.webtoon.pet.domain.event;

import com.kakao.webtoon.pet.domain.PetShop;
import lombok.Getter;

public class PetShopBuyedEvent {
    @Getter
    private final PetShop petShop;

    public PetShopBuyedEvent(PetShop petShop) {
        this.petShop = petShop;
    }
}
