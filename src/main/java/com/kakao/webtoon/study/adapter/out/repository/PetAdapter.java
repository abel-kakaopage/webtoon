package com.kakao.webtoon.study.adapter.out.repository;

import com.kakao.webtoon.study.application.port.out.FindPetPort;
import com.kakao.webtoon.study.application.port.out.UpdatePetPort;
import com.kakao.webtoon.study.domain.Pet;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PetAdapter implements FindPetPort, UpdatePetPort {

    private final PetMongoRepository petMongoRepository;

    private static Pet apply(PetEntity entity) {
        return Pet.builder().id(entity.getId()).petShopId(entity.getPetShopId()).kind(entity.getKind()).name(entity.getName()).age(entity.getAge()).created(entity.getCreated()).build();
    }

    private static PetEntity apply(Pet pet) {
        return PetEntity.builder().id(pet.getId()).petShopId(pet.getPetShopId()).kind(pet.getKind()).name(pet.getName()).age(pet.getAge()).created(pet.getCreated()).build();
    }

    @Override
    public Page<Pet> findAllPets(int page, int size, Sort sort) {
        Pageable pageable = PageRequest.of(page - 1, size, sort);
        Page<PetEntity> petEntities = petMongoRepository.findAll(pageable);
        List<Pet> pets = petEntities.stream().map(PetAdapter::apply).collect(Collectors.toList());
        return new PageImpl<>(pets, pageable, petEntities.getTotalElements());
    }

    @Override
    public Pet findPet(ObjectId id) {
        return petMongoRepository.findById(id).map(PetAdapter::apply).orElse(null);
    }

    @Override
    public void updatePet(Pet pet) {
        petMongoRepository.save(apply(pet));
    }
}
