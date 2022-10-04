package com.sparta.board.board.dto;

import lombok.Getter;

@Getter
public class BoardRequestsDTO {
    //protected : 같은 패키지는 아니지만 상속관계에서 사용할 수 있는 접근제어자
    protected String title;
    protected String username;
    protected String password;
    protected String content;
}
