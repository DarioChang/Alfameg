package com.alfameg.demo.repository;

import com.alfameg.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    public Page<User> findByPlaceOfBirth(String placeOfBirth, Pageable pageable);

}
