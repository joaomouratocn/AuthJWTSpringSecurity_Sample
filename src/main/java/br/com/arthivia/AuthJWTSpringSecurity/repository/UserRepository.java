package br.com.arthivia.AuthJWTSpringSecurity.repository;

import br.com.arthivia.AuthJWTSpringSecurity.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
   UserDetails findByLogin(String login);
}
