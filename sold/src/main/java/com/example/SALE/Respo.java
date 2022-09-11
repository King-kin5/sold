package com.example.SALE;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(collectionResourceRel = "dom", path = "dom")
public interface Respo extends JpaRepository<main,Integer> {
        List<main> findByItemId(@Param("ItemId")int ItemId);
}
