package com.kakao.webtoon.ticket.adapter.out.repository;

import com.kakao.webtoon.pet.adapter.out.repository.PetShopEntity;
import com.kakao.webtoon.pet.adapter.out.repository.PetShopMongoRepository;
import com.kakao.webtoon.ticket.domain.TicketCharge;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@Rollback(false)
class TicketChargeRepositoryTest {

    @Autowired
    private TicketChargeRepository ticketChargeRepository;

    @Test
    void insertPetShop() {
        TicketCharge ticketCharge = TicketCharge.builder().contentId(1L).userId(1L).initialCount(10).remainCount(5).initialBonusCount(2).initialBonusRemainCount(1).isRefunded(false).build();
        ticketChargeRepository.insert(ticketCharge);
        List<TicketCharge> ticketCharges = ticketChargeRepository.findByUserIdAndContentId(ticketCharge.getUserId(), ticketCharge.getContentId());
        assertNotNull(ticketCharges);
    }
}