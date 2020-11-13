package com.kakao.webtoon.study.adapter.out.repository;

import com.kakao.webtoon.study.application.port.out.FindPetShopPort;
import com.kakao.webtoon.study.application.port.out.UpdatePetShopPort;
import com.kakao.webtoon.study.domain.Pet;
import com.kakao.webtoon.study.domain.PetShop;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PetShopAdapter implements FindPetShopPort, UpdatePetShopPort {

    private final PetShopMongoRepository petShopMongoRepository;

    private static PetShop apply(PetShopEntity entity) {
        return PetShop.builder().id(entity.getId()).name(entity.getName()).build();
    }

    private static PetEntity apply(Pet pet) {
        return PetEntity.builder().id(pet.getId()).kind(pet.getKind()).name(pet.getName()).age(pet.getAge()).created(pet.getCreated()).build();
    }

    private static PetShopEntity apply(PetShop petShop) {
        List<PetEntity> pets = petShop.getPets().stream().map(PetShopAdapter::apply).collect(Collectors.toList());
        return PetShopEntity.builder().id(petShop.getId()).name(petShop.getName()).pets(pets).build();
    }

    @Override
    public PetShop findPetShop(ObjectId id) {
        Optional<PetShopEntity> petShopEntity = petShopMongoRepository.findById(id);
        return petShopEntity.map(PetShopAdapter::apply).orElse(null);
    }

    @Override
    public void updatePetShop(PetShop petshop) {
        petShopMongoRepository.save(apply(petshop));
    }
}
