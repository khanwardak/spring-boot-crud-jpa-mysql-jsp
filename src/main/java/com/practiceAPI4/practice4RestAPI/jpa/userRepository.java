package com.practiceAPI4.practice4RestAPI.jpa;

import com.practiceAPI4.practice4RestAPI.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
//here we use h2 database instead of static list in UserDoaService
public interface userRepository extends JpaRepository<Users, Integer> {

}
