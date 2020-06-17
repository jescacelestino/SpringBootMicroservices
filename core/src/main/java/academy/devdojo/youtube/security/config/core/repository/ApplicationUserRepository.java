package academy.devdojo.youtube.security.config.core.repository;


import academy.devdojo.youtube.security.config.core.model.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {
   public ApplicationUser findByUsername(String username);
}
