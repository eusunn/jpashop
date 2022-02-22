package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// repository 클래스파일은 DAO 같은 역할
@Repository
public class MemberRepository {

    @PersistenceContext // 스프링 컨테이너에서 받아쓰고 있기 때문에 이 어노테이션이 있으면 엔티티메니저를 주입을 해준다. (Starter data jpa)
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
        // 커맨드랑 쿼리를 분리해라! ?
    }
    // 멤바 조회
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
