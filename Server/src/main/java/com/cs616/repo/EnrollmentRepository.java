package com.cs616.repo;
import com.cs616.tables.Enrollment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "enrollment", path = "enrollment")
public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
    List<Enrollment> findByStudentid(@Param("studentid") String studentid);
}