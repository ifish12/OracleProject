package com.cs616.repo;
import com.cs616.tables.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByStudentid(@Param("studentid") String studentid);
}