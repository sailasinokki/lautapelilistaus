package fi.haagahelia.lautapelit.domain;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
ApplicationUser findByUsername(String username);
}
