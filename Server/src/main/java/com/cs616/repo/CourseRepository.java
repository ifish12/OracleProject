package com.cs616.repo;

import com.cs616.tables.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "courses", path = "courses")
public interface CourseRepository extends CrudRepository<Courses, Long> {
    //List<Courses> findByCourseid(@Param("courseid") int courseid);
}
