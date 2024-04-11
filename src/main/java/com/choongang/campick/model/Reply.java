package com.choongang.campick.model;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cmp_reply")
public class Reply {
	  private int cmp_no;				// 캠핑장번호
	  private String user_id;			// 회원아이디
	  private String re_content;		// 댓글 내용
	  private Timestamp re_date;		// 댓글 작성 날짜
}
