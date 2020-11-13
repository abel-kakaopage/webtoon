package com.kakao.webtoon.study.application.port.in;

import org.bson.types.ObjectId;

public interface BuyPetUseCase {
    boolean buyPet(ObjectId petId, ObjectId petShopId);
}
