package academy.devdojo.youtube.security.config.core.repository;


import academy.devdojo.youtube.security.config.core.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
