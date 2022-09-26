package com.kim.biz.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO selectOneBoard(BoardVO vo);
	List<BoardVO> selectAllBoard(BoardVO vo);
}
