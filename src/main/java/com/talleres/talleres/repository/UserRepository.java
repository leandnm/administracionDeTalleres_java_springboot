package com.talleres.talleres.repository;

import com.talleres.talleres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
