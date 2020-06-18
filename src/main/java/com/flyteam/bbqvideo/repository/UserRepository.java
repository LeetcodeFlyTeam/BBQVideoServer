package com.flyteam.bbqvideo.repository;

import com.flyteam.bbqvideo.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDao,Integer> {
    UserDao getUserDaoByUserNameAndPassword(String userName, String password);
    List<UserDao> getUserDaoByUserName(String userName);
}
