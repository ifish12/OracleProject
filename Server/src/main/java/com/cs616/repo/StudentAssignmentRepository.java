package com.cs616.repo;

import com.cs616.tables.Courses;
import com.cs616.tables.StudentAssignments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "studentassignments", path = "studentassignments")
public interface StudentAssignmentRepository extends CrudRepository<StudentAssignments, Long> {

}