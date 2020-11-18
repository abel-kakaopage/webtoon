package com.kakao.webtoon.ticket.application.port.out;

import com.kakao.webtoon.ticket.application.port.in.FindTicketChageQuery;
import com.kakao.webtoon.ticket.domain.TicketCharge;

import java.util.List;

public interface FindTicketChargePort {
    List<TicketCharge> find(FindTicketChageQuery query);
}
