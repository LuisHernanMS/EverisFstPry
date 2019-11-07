package com.everis.prycliente.apphandler;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.MediaType.*;

import java.net.URI;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.everis.prycliente.models.Student;
import com.everis.prycliente.services.StudentService;

import reactor.core.publisher.Mono;

@Component
public class StudentHandler {
	
	@Autowired
	private StudentService service;

	public Mono<ServerResponse> listar(ServerRequest request){
		return ServerResponse.ok().contentType(APPLICATION_JSON_UTF8)
				.body(service.findAll(), Student.class);
	}
	
	public Mono<ServerResponse> ver(ServerRequest request){
		String id = request.pathVariable("id");
		return ServerResponse.ok().contentType(APPLICATION_JSON_UTF8)
				.body(service.findById(id), Student.class);
	}
	
	public Mono<ServerResponse> crear(ServerRequest request){
		Mono<Student> student = request.bodyToMono(Student.class);
		return student.flatMap(p -> {
			return service.save(p);
		}).flatMap(p -> ServerResponse.created(URI.create("api/client/".concat(p.getId())))
				.contentType(APPLICATION_JSON_UTF8)
				.syncBody(p));
	}
	
	public Mono<ServerResponse> editar(ServerRequest request){
		Mono<Student> student= request.bodyToMono(Student.class);
		String id = request.pathVariable("id");
		
		return student.flatMap(p -> ServerResponse.created(URI.create("/api/client/".concat(id)))
				.contentType(APPLICATION_JSON_UTF8)
				.body(service.update(p, id), Student.class));
	}
	
	public Mono<ServerResponse> eliminar(ServerRequest request){
		String id = request.pathVariable("id");
		
		return service.delete(id).then(ServerResponse.noContent().build());
	}
	
}
