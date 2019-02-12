package com.kiseok.repository;

import com.kiseok.domain.Board;
import com.kiseok.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
