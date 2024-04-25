package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetOneRes;
import com.green.boardver2.board.model.BoardGetRes;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.board.model.BoardPutReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int postBoard(BoardPostReq p);
    int deleteBoard(long boardId);
    List<BoardGetRes> getBoardList();
    BoardGetOneRes getBoardOne(long boardId);
    int putBoard(BoardPutReq p);
}
