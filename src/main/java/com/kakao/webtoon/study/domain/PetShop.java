package com.kakao.webtoon.study.domain;

import com.kakao.webtoon.study.domain.Pet;
import com.kakao.webtoon.study.domain.event.Events;
import com.kakao.webtoon.study.domain.event.PetShopBuyedEvent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
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
            Events.raise(new PetShopBuyedEvent());
        }
    }
}
