package com.kakao.webtoon.pet.domain.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class PetShopBuyedEventListner {

    @Async
//    @EventListener 트랜잭션과 무관하게 바로 실행되도 될경우
    @TransactionalEventListener
    public void listen(PetShopBuyedEvent event) {
        log.info("이벤트 리스너 진입 "+event.getPetShop().getName());
    }
}
