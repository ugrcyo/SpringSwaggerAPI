package com.ugrcyo.first.repository;

import com.ugrcyo.first.domain.post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<post,Long > {
}
