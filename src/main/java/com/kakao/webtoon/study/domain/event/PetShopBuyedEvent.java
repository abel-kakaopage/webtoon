package com.kakao.webtoon.study.domain.event;

import com.kakao.webtoon.study.domain.PetShop;
import lombok.Getter;

public class PetShopBuyedEvent {
    @Getter
    private final PetShop petShop;

    public PetShopBuyedEvent(PetShop petShop) {
        this.petShop = petShop;
    }
}
