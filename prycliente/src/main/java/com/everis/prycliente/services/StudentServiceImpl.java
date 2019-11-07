package com.everis.prycliente.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.everis.prycliente.models.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private WebClient.Builder client;
	
	@Override
	public Flux<Student> findAll() {
		
		return client.build().get().accept(APPLICATION_JSON_UTF8)
				.exchange()
				.flatMapMany(response -> response.bodyToFlux(Student.class));
	}

	@Override
	public Flux<Student> findById(String id) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		return client.build().get().uri("/{id}", params)
				.accept(APPLICATION_JSON_UTF8)
				.exchange()
				.flatMapMany(response -> response.bodyToFlux(Student.class));
				//.retrieve()
				//.bodyToMono(Student.class);
	}

	@Override
	public Mono<Student> save(Student student) {
		
		return client.build().post()
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(student))
				.syncBody(student)
				.retrieve()
				.bodyToMono(Student.class);
	}

	@Override
	public Mono<Student> update(Student student, String id) {
		
		return client.build().put()
				.uri("/{id}",Collections.singletonMap("id", id))
				.accept(APPLICATION_JSON_UTF8)
				.contentType(APPLICATION_JSON_UTF8)
				//.body(fromObject(student))
				.syncBody(student)
				.retrieve()
				.bodyToMono(Student.class);
	}

	@Override
	public Mono<Void> delete(String id) {
		
		return client.build().delete().uri("/{id}",Collections.singletonMap("id", id))
				.exchange()
				.then();
	}

}
