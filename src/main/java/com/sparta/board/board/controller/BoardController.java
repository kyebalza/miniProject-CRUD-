package com.sparta.board.board.controller;

import com.sparta.board.board.dto.BoardRequestsDTO;
import com.sparta.board.board.entity.Board;
import com.sparta.board.board.repository.BoardRepository;
import com.sparta.board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    //잔체 게시글 목록 조회(GET)
    @GetMapping("/api/board")
    public List<Board> getBoards(){

        return boardService.getBoards();
    }


    //게시글 작성(POST)
    @PostMapping("/api/board")
    public Board createBoard(@RequestBody BoardRequestsDTO boardRequestsDTO){
        Board board =new Board(boardRequestsDTO);
        return boardService.create(board);
    }


    //게시글 조회(GET)
    @GetMapping("/api/board/{id}")
    public Board getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }


    //게시글 비밀번호 확인(GET)
    @GetMapping("/api/board/{id}/{password}")
    public boolean getBoardPassword(@PathVariable Long id,@PathVariable String password){
        return boardService.getBoardPassword(id, password);
    }

    //게시글 삭제(DELETE)
    @DeleteMapping("/api/board/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // "/api/memos/" 라는 경로에 {id} 변수를 넘겨주기 위해서는
        // PathVariable이라는 어노테이션이 꼭 필요하다.
        boardService.delete(id);
        return id;
    }

    //게시글 수정(UPDATE)
    @PutMapping("/api/board/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody BoardRequestsDTO requestDto) {
        boardService.update(id, requestDto);
        return id;
    }

}
