package com.sparta.board.board.entity;

import com.sparta.board.board.dto.BoardRequestsDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter //get메서드를 생성해주는 어노테이션
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Board extends Timestamped{// 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String content;

    public Board(String title, String username, String password, String content){
        this.title = title;
        this.username = username;
        this.password = password;
        this.content = content;
    }

    public Board(BoardRequestsDTO requestsDTO){
        this.title = requestsDTO.getTitle();
        this.username= requestsDTO.getUsername();
        this.password = requestsDTO.getPassword();
        this.content = requestsDTO.getContent();
    }

    public void update(BoardRequestsDTO requestsDTO){
        this.title = requestsDTO.getTitle();
        this.username = requestsDTO.getUsername();
        this.password = requestsDTO.getPassword();
        this.content = requestsDTO.getContent();
    }


}
