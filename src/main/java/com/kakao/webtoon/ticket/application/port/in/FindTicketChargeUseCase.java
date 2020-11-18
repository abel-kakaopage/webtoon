package com.kakao.webtoon.ticket.application.port.in;

import com.kakao.webtoon.ticket.domain.TicketCharge;

import java.util.List;

public interface FindTicketChargeUseCase {
    List<TicketCharge> find(FindTicketChageQuery query);
}
