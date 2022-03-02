package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
//    ->   @RequiredArgsConstructor 요게 아래 세줄을 포함해줌
//    public MemberRepository(EntityManager em) {
//        this.em = em;
//    }

    public void save (Member member) {
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
        // sql은 테이블을 대상으로 쿼리를 하는 것이고
        // 우리가 사용한 것은 엔티티 객체를 대상으로 쿼리를 하는것 (엘리어스를 m으로 두고 엔티티 member를 조회해)
    }
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
