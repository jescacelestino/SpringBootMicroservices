package academy.devdojo.youtube.security.config.course.endpoint.service;

import academy.devdojo.youtube.security.config.core.model.Course;
import academy.devdojo.youtube.security.config.core.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CouseService {
    private final CourseRepository courseRepository;

    public Iterable<Course> list (Pageable pageable){
        log.info("Listing all courses");
        return courseRepository.findAll(pageable);
    }

}