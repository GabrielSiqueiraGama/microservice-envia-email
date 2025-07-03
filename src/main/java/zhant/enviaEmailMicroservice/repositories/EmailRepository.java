package zhant.enviaEmailMicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import zhant.enviaEmailMicroservice.models.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long>{

}
