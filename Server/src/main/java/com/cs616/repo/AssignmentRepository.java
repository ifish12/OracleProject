package com.cs616.repo;

import com.cs616.tables.Assignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "assignments", path = "assignments")
public interface AssignmentRepository extends CrudRepository<Assignments, Long> {
    List<Assignments> findByCourseid(@Param("courseid") int courseid);
}
