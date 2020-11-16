package com.kakao.webtoon.study.domain;

import com.kakao.webtoon.common.event.Events;
import com.kakao.webtoon.study.domain.event.PetShopBuyedEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PetShop {
    @Getter
    private ObjectId id;
    @Getter
    private String name;
    @Getter
    private List<Pet> pets;
    @Getter
    private boolean isBuy;

    public void buyPet(Pet pet) {
        if (this.pets == null)
            this.pets = new ArrayList<>();

        if (this.pets.stream().noneMatch(p -> p.getId().equals(pet.getId()))) {
            this.pets.add(pet);
            Events.publish(new PetShopBuyedEvent(this)); // 도메인 로직 실패시 어떻게 될까???
        }
    }
}
