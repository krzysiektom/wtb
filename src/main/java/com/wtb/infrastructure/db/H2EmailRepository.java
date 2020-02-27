package com.wtb.infrastructure.db;

import com.wtb.domain.email.Email;
import com.wtb.domain.email.EmailRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface H2EmailRepository extends JpaRepository<Email, Long>, EmailRepository {
}