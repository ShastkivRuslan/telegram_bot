package com.project.telegram_bot.repository;

import com.project.telegram_bot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
