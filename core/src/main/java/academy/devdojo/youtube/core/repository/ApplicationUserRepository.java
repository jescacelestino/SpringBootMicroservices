package academy.devdojo.youtube.core.repository;


import academy.devdojo.youtube.core.model.ApplicationUser;
import academy.devdojo.youtube.core.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);
}
