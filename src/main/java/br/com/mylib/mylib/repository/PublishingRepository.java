package br.com.mylib.mylib.repository;

import br.com.mylib.mylib.model.Publishing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublishingRepository extends JpaRepository<Publishing, Long> {
}
