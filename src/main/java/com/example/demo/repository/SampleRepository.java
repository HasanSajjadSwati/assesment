package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SampleModel;

public interface SampleRepository extends JpaRepository<SampleModel, Integer>{

}
