package com.kakao.webtoon.study.adapter.out.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Rollback(false)
class PetEntityTest {

    @Autowired
    PetMongoRepository petMongoRepository;

    @BeforeEach
    void delete() {
//        petMongoRepository.deleteAll();
    }

    @Test
    void insertPet() {
        PetEntity pet = PetEntity.builder().kind("DOG").name("똥개").age(5).build();
        petMongoRepository.insert(pet);
        Optional<PetEntity> findPet = petMongoRepository.findById(pet.getId());
        assertTrue(findPet.isPresent());
        assertThat(pet.getId()).isEqualTo(findPet.get().getId());
    }

//    @Test
//    void updatePet() {
//        PetEntity pet = PetEntity.builder().kind("CAT").name("나비").age(6).build();
//        petMongoRepository.insert(pet);
//        PetEntity petUpdated = PetEntity.builder().kind("COW").name("소").build();
//        pet.update(petUpdated);
//        petMongoRepository.save(pet);
//        Optional<PetEntity> findPet = petMongoRepository.findById(pet.getId());
//        assertTrue(findPet.isPresent());
//        assertThat(pet.getId()).isEqualTo(findPet.get().getId());
//    }

    @Test
    void findAllPetsSortASC() {
        PetEntity pet = PetEntity.builder().kind("DOG").name("개").age(5).build();
        petMongoRepository.insert(pet);
        pet = PetEntity.builder().kind("COW").name("소").age(5).build();
        petMongoRepository.insert(pet);
        pet = PetEntity.builder().kind("CAT").name("고양이").age(5).build();
        petMongoRepository.insert(pet);
        List<PetEntity> pets = petMongoRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        assertThat(pets.size()).isEqualTo(3);
        assertThat(pets.get(0).getName()).isEqualTo("개");
        assertThat(pets.get(1).getName()).isEqualTo("고양이");
        assertThat(pets.get(2).getName()).isEqualTo("소");
    }

    @Test
    void findAllPetsSortASCPaging() {
        LocalDateTime now = LocalDateTime.now();
        PetEntity pet = PetEntity.builder().kind("DOG").name("개").age(5).created(now.minusDays(2)).build();
        petMongoRepository.insert(pet);
        pet = PetEntity.builder().kind("COW").name("소").age(5).created(now.minusDays(5)).build();
        petMongoRepository.insert(pet);
        pet = PetEntity.builder().kind("CAT").name("고양이").age(5).created(now.minusDays(3)).build();
        petMongoRepository.insert(pet);
        pet = PetEntity.builder().kind("RABBIT").name("토끼").age(5).created(now.minusDays(2)).build();
        petMongoRepository.insert(pet);
        pet = PetEntity.builder().kind("LION").name("사자").age(5).created(now).build();
        petMongoRepository.insert(pet);
        // paging, sort name
        Pageable pageable = PageRequest.of(0, 2, Sort.by("name").ascending());
        Page<PetEntity> pets = petMongoRepository.findAll(pageable);
        assertThat(pets.getContent().size()).isEqualTo(2);
        assertThat(pets.getContent().get(0).getName()).isEqualTo("개");
        assertThat(pets.getContent().get(1).getName()).isEqualTo("고양이");
        // paging, sort created
        pageable = PageRequest.of(1, 2, Sort.by("created").descending());
        pets = petMongoRepository.findAll(pageable);
        assertThat(pets.getContent().size()).isEqualTo(2);
        assertThat(pets.getContent().get(0).getName()).isEqualTo("개");
        assertThat(pets.getContent().get(1).getName()).isEqualTo("고양이");
        // paging, multi sort
        Sort multiSort = Sort.by("created").descending().and(Sort.by("kind").ascending());
        pageable = PageRequest.of(0, 3, multiSort);
        pets = petMongoRepository.findAll(pageable);
        assertThat(pets.getContent().size()).isEqualTo(3);
        assertThat(pets.getContent().get(0).getName()).isEqualTo("사자");
        assertThat(pets.getContent().get(1).getName()).isEqualTo("개");
        assertThat(pets.getContent().get(2).getName()).isEqualTo("토끼");
    }
}