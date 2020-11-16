package com.kakao.webtoon.pet.adapter.out.repository;

import com.kakao.webtoon.pet.application.port.out.FindPetShopPort;
import com.kakao.webtoon.pet.application.port.out.UpdatePetShopPort;
import com.kakao.webtoon.pet.domain.Pet;
import com.kakao.webtoon.pet.domain.PetShop;
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

    private static Pet convertPetDomain(PetEntity pet) {
        return Pet.builder().id(pet.getId()).kind(pet.getKind()).name(pet.getName()).age(pet.getAge()).created(pet.getCreated()).build();
    }

    private static PetEntity convertPetEntity(Pet pet) {
        return PetEntity.builder().id(pet.getId()).kind(pet.getKind()).name(pet.getName()).age(pet.getAge()).created(pet.getCreated()).build();
    }

    private static PetShop convertPetShopDomain(PetShopEntity entity) {
        List<Pet> pets = entity.getPets().stream().map(PetShopAdapter::convertPetDomain).collect(Collectors.toList());
        return PetShop.builder().id(entity.getId()).name(entity.getName()).pets(pets).build();
    }

    private static PetShopEntity convertPetShopEntity(PetShop petShop) {
        List<PetEntity> pets = petShop.getPets().stream().map(PetShopAdapter::convertPetEntity).collect(Collectors.toList());
        return PetShopEntity.builder().id(petShop.getId()).name(petShop.getName()).pets(pets).build();
    }

    @Override
    public PetShop findPetShop(ObjectId id) {
        Optional<PetShopEntity> petShopEntity = petShopMongoRepository.findById(id);
        return petShopEntity.map(PetShopAdapter::convertPetShopDomain).orElse(null);
    }

    @Override
    public void updatePetShop(PetShop petshop) {
        petShopMongoRepository.save(convertPetShopEntity(petshop));
    }
}
