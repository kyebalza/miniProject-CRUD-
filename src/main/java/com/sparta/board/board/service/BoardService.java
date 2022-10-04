package com.sparta.board.board.service;

import com.sparta.board.board.entity.Board;
import com.sparta.board.board.dto.BoardRequestsDTO;
import com.sparta.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //잔체 게시글 목록 조회(GET)
    public List<Board> getBoards(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }

    //게시글 작성(POST)
    public Board create(Board board){
        return boardRepository.save(board);
    }

    //게시글 조회(GET)
    public Board getBoard(Long id){
        Board board = boardRepository.findById(id).get();
        return board;
    }

    //게시글 비밀번호 확인(GET)
    public boolean getBoardPassword(Long id, String password){
        Board board = boardRepository.findById(id).get();
        if (!board.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    //게시글 삭제(DELETE)
    public Long delete(Long id) {
        // "/api/memos/" 라는 경로에 {id} 변수를 넘겨주기 위해서는
        // PathVariable이라는 어노테이션이 꼭 필요하다.
        boardRepository.deleteById(id);

        return id;
    }
    //게시글 수정(UPDATE)
    @Transactional// 이 메소드가 SQL 쿼리로서 작동하는 메소드구나를 알려주는 어노테이션
    //트랜잭션 roolback // 변경상태 확인 더티체킹 // commit 상태
    public Long update(Long id, BoardRequestsDTO requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

//    //방법2
//    public Long update(Long id, BoardRequestsDTO requestDto) {
//        Board board = boardRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );
//        board.update(requestDto);
//        boardRepository.save(board);//save DB에 저장해주는 작업//트랜잭션을 사용하면 save을 안써도 됨.
//        return board.getId();
//    }

}
