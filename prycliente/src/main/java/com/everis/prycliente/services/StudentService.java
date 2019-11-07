package com.everis.prycliente.services;

import com.everis.prycliente.models.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

	public Flux<Student> findAll();
	
	public Flux<Student> findById(String id);
	
	public Mono<Student> save(Student student);
	
	public Mono<Student> update(Student student, String id);
	
	public Mono<Void> delete(String id);
	
	
}
