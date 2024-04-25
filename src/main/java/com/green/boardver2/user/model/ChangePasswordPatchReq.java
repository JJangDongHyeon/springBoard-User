package com.green.boardver2.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordPatchReq {
    //아이디 , 이름
    //uid , nm , 신규 비밀번호

    // 대상 지정 (pk or 아이디), 기존 비밀번호(대상의 원 주인인지 체크) , 신규 비밀번호
    //pk를 모르기 때ㅔ문에 아이디만 가능
    @JsonIgnore
    private long userId; //이러면 프론트에서 안뜸
    private String uid;
    private String currentPw;
    private String newPw;

}
