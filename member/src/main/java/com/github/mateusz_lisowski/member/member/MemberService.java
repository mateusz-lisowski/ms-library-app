package com.github.mateusz_lisowski.member.member;

import com.github.mateusz_lisowski.member.member.schemas.MemberCrateRequest;
import com.github.mateusz_lisowski.member.member.schemas.MemberResponse;
import com.github.mateusz_lisowski.member.member.schemas.MemberUpdateRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository repository;
    private final MemberMapper mapper;

    public MemberResponse create(MemberCrateRequest request) {
        Member member = mapper.toMember(request);
        return mapper.toMemberResponse(repository.save(member));
    }

    public MemberResponse findById(UUID uuid) {
        return repository.findById(uuid).map(mapper::toMemberResponse).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with id: " + uuid + " not found")
        );
    }

    public List<MemberResponse> findAll() {
        return repository.findAll().stream().map(mapper::toMemberResponse).toList();
    }


    public MemberResponse update(UUID uuid, MemberUpdateRequest request) {
        Member member = repository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with id: " + uuid + " not found")
        );
        member.setFirstname(request.firstname());
        member.setLastname(request.lastname());
        return mapper.toMemberResponse(repository.save(member));
    }

    public void delete(UUID uuid) {
        Member member = repository.findById(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with id: " + uuid + " not found")
        );
        repository.delete(member);
    }

}
