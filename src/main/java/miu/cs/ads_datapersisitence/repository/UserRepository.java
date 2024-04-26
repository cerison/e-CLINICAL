package miu.cs.ads_datapersisitence.repository;

import miu.cs.ads_datapersisitence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}