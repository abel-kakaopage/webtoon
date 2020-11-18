package com.kakao.webtoon.ticket.adapter.in.controller;

import com.kakao.webtoon.ticket.application.port.in.FindTicketChargeUseCase;
import com.kakao.webtoon.ticket.application.port.in.UseTicketCommand;
import com.kakao.webtoon.ticket.application.port.in.UseTicketUseCase;
import com.kakao.webtoon.ticket.application.port.out.FindTicketChargePort;
import com.kakao.webtoon.ticket.application.port.in.FindTicketChageQuery;
import com.kakao.webtoon.ticket.domain.TicketCharge;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final FindTicketChargeUseCase findTicketChargeUseCase;
    private final UseTicketUseCase useTicketUseCase;

    @GetMapping("/list")
    public List<TicketCharge> findAllTicketCharge(@RequestParam(value = "user_id") Long userId,
                                                  @RequestParam(value = "content_id") Long contentId) {
        return findTicketChargeUseCase.find(FindTicketChageQuery.builder().userId(userId).contentId(contentId).build());
    }

    @PostMapping("/use")
    public boolean ticketUse(@RequestParam(value = "user_id") Long userId,
                             @RequestParam(value = "content_id") Long contentId,
                             @RequestParam(value = "episode_id") Long episodeId) {
        return useTicketUseCase.use(UseTicketCommand.builder().userId(userId).contentId(contentId).e.build());
    }
}
