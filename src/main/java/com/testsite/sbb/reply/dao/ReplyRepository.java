package com.testsite.sbb.reply.dao;

import com.testsite.sbb.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
