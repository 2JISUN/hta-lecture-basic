package com.jisun.service;

import java.util.List;

import com.jisun.dto.BoardDto;

public interface BoardService {
	int write(BoardDto boardDto);
	List<BoardDto> list();
	int getMaxRegroup();
}