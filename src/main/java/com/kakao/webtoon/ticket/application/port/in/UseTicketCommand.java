package com.kakao.webtoon.ticket.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class UseTicketCommand {
    @NonNull
    Long userId;

}
