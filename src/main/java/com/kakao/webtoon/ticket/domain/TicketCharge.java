package com.kakao.webtoon.ticket.domain;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "ticket_charge")
@Getter
@Builder
public class TicketCharge {
    @Id
    private ObjectId id;
    private Long userId;
    private Long contentId;
    private Integer initialCount;
    private Integer remainCount;
    private Integer initialBonusCount;
    private Integer initialBonusRemainCount;
    private Boolean isRefunded;
}
