package com.varvashevich.serviceTest;

import com.varvashevich.configuration.ServiceConfiguration;
import com.varvashevich.entity.Tag;
import com.varvashevich.repository.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class TagServiceTest {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private EntityManager manager;

    @Test
    public void checkFindByName() {
        Tag tag = Tag.builder()
                .name("repositoryTestTag")
                .build();
        Tag savedTag = tagRepository.save(tag);

        manager.detach(tag);

        Optional<Tag> optionalTag = tagRepository.findByName(savedTag.getName());
        assertTrue(optionalTag.isPresent());
    }
}