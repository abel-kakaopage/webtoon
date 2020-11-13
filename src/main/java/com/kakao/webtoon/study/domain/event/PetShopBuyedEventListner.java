package com.kakao.webtoon.study.domain.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class PetShopBuyedEventListner {

    @Async
    @EventListener
    public void handle(PetShopBuyedEvent event) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> 이벤트 리스너");
    }
}
