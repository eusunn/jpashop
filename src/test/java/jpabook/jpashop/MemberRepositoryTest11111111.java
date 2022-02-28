//package jpabook.jpashop;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberRepositoryTest11111111 {
//
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testMember() throws Exception {
//
//        //given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        //when
//        Long savedId = memberRepository.save(member);
//        Member findMember = memberRepository.find(savedId);
//
//        //then
//        Assertions.assertThat(findMember.getId()).isEqualTo(findMember.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(findMember.getUsername());
//        Assertions.assertThat(findMember).isEqualTo(member);
//        System.out.println("findMember == member : " + (findMember == member)); //true
//        // 같은 트렌젝션안에서 저장되면 영속성 컨텍스트가 같을 것 그래서 아이디값이 같으면 같은 엔티티로 인식한다.
//    }
//
//}