package com.kakao.webtoon.ticket.adapter.out.repository;

import com.kakao.webtoon.ticket.domain.TicketCharge;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TicketChargeRepository extends MongoRepository<TicketCharge, ObjectId> {

    List<TicketCharge> findByUserIdAndContentId(Long userId, Long contentId);
}
