package com.kakao.webtoon.study.domain;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class PetShopBuyedEventListner {

    @Async
    @EventListener
    public void handle(PetShopBuyedEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> 이벤트 리스너");
    }
}
