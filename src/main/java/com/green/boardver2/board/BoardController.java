package com.green.boardver2.board;

import com.green.boardver2.board.model.BoardGetOneRes;
import com.green.boardver2.board.model.BoardGetRes;
import com.green.boardver2.board.model.BoardPostReq;
import com.green.boardver2.board.model.BoardPutReq;
import com.green.boardver2.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService boardService;


    @PostMapping
    public ResultDto<Integer> postBoard(BoardPostReq p){
        int result = boardService.postBoard(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }

    @DeleteMapping
    public ResultDto<Integer> deleteBoard(@RequestParam(name = "board_id") long boardId){
        int result = boardService.deleteBoard(boardId);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(HttpStatus.OK.toString())
                .resultData(result).build();
    }

    @GetMapping
    public ResultDto<List<BoardGetRes>> getBoardList() {
        List<BoardGetRes> list = boardService.getBoardList();

        return ResultDto.<List<BoardGetRes>>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg(String.format("row_count: %d", list.size()))
                .resultData(list).build();
    }
    @GetMapping("{boardId}")
    public BoardGetOneRes getBoardOne(@PathVariable long boardId){
        return boardService.getBoardOne(boardId);
    }

    @PutMapping
    public int putBoard(@RequestBody BoardPutReq p){
        return boardService.putBoard(p);
    }
}
