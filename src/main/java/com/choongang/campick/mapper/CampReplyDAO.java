package com.choongang.campick.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.choongang.campick.model.Reply;

@Mapper
public interface CampReplyDAO {

	// 댓글 작성
	public int insertReply(Reply reply);
	
	// 댓글 조회
	public Reply selectReply(String user_id);

	// 댓글 삭제 
	public int deleteReply(String user_id);
	

}
