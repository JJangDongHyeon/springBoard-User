package com.green.boardver2.user;

import com.green.boardver2.user.model.ChangePasswordPatchReq;
import com.green.boardver2.user.model.SignInPostReq;
import com.green.boardver2.user.model.UserEntity;
import com.green.boardver2.user.model.UserPostReq;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public int postUser(UserPostReq p){
        //비밀번호 암호화 salt기법 : 모든 비밀번호의 암호화 패턴이 다름
        String hashedPassword = BCrypt.hashpw(p.getUpw() , BCrypt.gensalt()); //UserPostReq의 비밀번호 설정
        p.setUpw(hashedPassword); // 설정한걸 다시 날려줌
        return userMapper.postUser(p);
    }
        //1: 로그인 성공 2: 아이디 없음 3:비밀번호 다름
    public int postSignin(SignInPostReq p){
        UserEntity entity = userMapper.getUserById(p.getUid());
        if (entity == null) { return 2; }

        if(BCrypt.checkpw(p.getUpw() , entity.getUpw())) {
            return 1;
        }
        return 3;

    }

    public int patchPassword(ChangePasswordPatchReq p ){
        //현재 비밀번호,
        UserEntity entity = userMapper.getUserById(p.getUid());
        if(entity == null){
            return 2;
        } else if (!BCrypt.checkpw(p.getCurrentPw(), entity.getUpw())) {
            return 3;
        }
        //비밀번호 변경
        String hashedPassword = BCrypt.hashpw(p.getNewPw() , BCrypt.gensalt());
        p.setNewPw(hashedPassword);
        p.setUserId(entity.getUserId());
        return userMapper.patchPassword(p);


    }
}
