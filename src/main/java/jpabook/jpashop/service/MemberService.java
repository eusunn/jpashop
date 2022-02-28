package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)  // 조회할 데이터가 더 많으면 이렇게 설정해주고 데이터를 변경해야할 때만 지정해준다.
@RequiredArgsConstructor
public class MemberService {

//    @Autowired
    private final MemberRepository memberRepository;// 단점 테스트할 댸 변경이 불가능한 경우가 있다. 필드고 프라이빗한 형태라서

//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) { // 장점 테스트를 할때 주입이 편하다. //단점은 실제 애플리케이션이 잘 동작할 때 사용할일이 없기때문에 잘 사용하지 않음
//        this.memberRepository = memberRepository;
//    }

    //회원 가입
    @Transactional // 데이터를 쓸 때는 readonly = true를 넣으면 데이터 변경이 안돼기때문에 하면 안됀다. 디폴트가 false
    public Long join(Member member) {

        validateDuplicateMember(member);// 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    // 회원 전체 조회
//    @Transactional(readOnly = true) // 데이터를 읽을 때(조회)는 readonly = true를 설정해준다.
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

//    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
