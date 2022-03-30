package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepositoryOld memberRepositoryOld;

    @Transactional
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepositoryOld.save(member);
        return member.getId();
    }

    public List<Member> findMembers() {
        return memberRepositoryOld.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepositoryOld.findOne(memberId);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepositoryOld.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepositoryOld.findOne(id);
        member.setName(name);
    }
}
