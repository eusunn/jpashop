package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Member {
    //식별자를 Id에 매핑을해주고 @GeneratedValue사용하여 자동생성되게 해준다.
    @Id @GeneratedValue
    private Long id;
    private String username;


}
