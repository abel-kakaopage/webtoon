package com.kakao.webtoon.ticket.adapter.out.adapter;

import com.kakao.webtoon.ticket.adapter.out.repository.TicketChargeRepository;
import com.kakao.webtoon.ticket.application.port.out.FindTicketChargePort;
import com.kakao.webtoon.ticket.application.port.in.FindTicketChageQuery;
import com.kakao.webtoon.ticket.domain.TicketCharge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketChargeAdapter implements FindTicketChargePort {

    private final TicketChargeRepository ticketChargeRepository;

    @Override
    public List<TicketCharge> find(FindTicketChageQuery query) {
        return ticketChargeRepository.findByUserIdAndContentId(query.getUserId(), query.getContentId());
    }
}
