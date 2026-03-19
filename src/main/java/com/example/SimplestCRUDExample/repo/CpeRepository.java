package com.example.SimplestCRUDExample.repo;

import com.example.SimplestCRUDExample.model.Cpe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CpeRepository extends JpaRepository<Cpe, Long> {

    List<Cpe> findAllByOrderByIdAsc();

    List<Cpe> findByCpeTitleContainingIgnoreCase(String title);

    List<Cpe> findByCpe22UriContainingIgnoreCase(String uri);

}