package com.kakao.webtoon.ticket.application.service;

import com.kakao.webtoon.ticket.application.port.in.FindTicketChageQuery;
import com.kakao.webtoon.ticket.application.port.in.FindTicketChargeUseCase;
import com.kakao.webtoon.ticket.application.port.out.FindTicketChargePort;
import com.kakao.webtoon.ticket.domain.TicketCharge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketChargeService implements FindTicketChargeUseCase {

    private final FindTicketChargePort findTicketChargePort;

    @Override
    public List<TicketCharge> find(FindTicketChageQuery query) {
        return null;
    }
}
