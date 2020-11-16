package com.kakao.webtoon.pet.adapter.out.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Rollback(false)
class PetShopMongoRepositoryTest {

    @Autowired
    private PetShopMongoRepository petShopMongoRepository;

    @Test
    void insertPetShop() {
        PetShopEntity petshop = PetShopEntity.builder().name("dog world").build();
        petShopMongoRepository.insert(petshop);
        Optional<PetShopEntity> findPetshop = petShopMongoRepository.findById(petshop.getId());
        assertTrue(findPetshop.isPresent());
        assertThat(petshop.getId()).isEqualTo(findPetshop.get().getId());
    }
}