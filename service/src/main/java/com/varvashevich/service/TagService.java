package com.varvashevich.service;

import com.varvashevich.entity.Tag;
import com.varvashevich.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TagService {

    private final TagRepository tagRepository;

    public Optional<Tag> findByName(String name) {
        return tagRepository.findByName(name);
    }

    public Iterable<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Transactional
    public Tag save(Tag tag) {
        return tagRepository.save(Tag.builder().name(tag.getName()).build());
    }
}
