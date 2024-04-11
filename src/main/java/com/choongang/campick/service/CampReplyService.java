package com.choongang.campick.service;

import org.springframework.stereotype.Service;

import com.choongang.campick.mapper.CampReplyDAO;
import com.choongang.campick.model.Reply;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CampReplyService {
	
	private final CampReplyDAO dao;
	
	
	// 댓글 작성
	public int insertReply(Reply reply) {
		return dao.insertReply(reply);
	}

	// 댓글 조회
	public Reply selectReply(String user_id) {
		return dao.selectReply(user_id);
	}

	// 댓글 삭제
	public int deleteReply(String user_id) {
		return dao.deleteReply(user_id);
	}

}
