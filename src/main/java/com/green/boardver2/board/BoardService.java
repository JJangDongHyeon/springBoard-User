package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetOneRes;
import com.green.boardver2.board.model.BoardGetRes;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.board.model.BoardPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public int postBoard(BoardPostReq p){
        return boardMapper.postBoard(p);
    }
    public int deleteBoard(long boardId){
        return boardMapper.deleteBoard(boardId);
    }
    public List<BoardGetRes> getBoardList(){
        return boardMapper.getBoardList();
    }
    public BoardGetOneRes getBoardOne(long boardId){
        return boardMapper.getBoardOne(boardId);
    }
    public int putBoard(BoardPutReq p){
        return boardMapper.putBoard(p);
    }
}
