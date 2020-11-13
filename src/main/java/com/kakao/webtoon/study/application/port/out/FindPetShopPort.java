package com.kakao.webtoon.study.application.port.out;

import com.kakao.webtoon.study.domain.PetShop;
import org.bson.types.ObjectId;

public interface FindPetShopPort {
    PetShop findPetShop(ObjectId id);
}
