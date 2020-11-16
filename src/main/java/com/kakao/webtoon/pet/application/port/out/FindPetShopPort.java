package com.kakao.webtoon.pet.application.port.out;

import com.kakao.webtoon.pet.domain.PetShop;
import org.bson.types.ObjectId;

public interface FindPetShopPort {
    PetShop findPetShop(ObjectId id);
}
