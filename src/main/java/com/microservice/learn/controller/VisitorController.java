package com.microservice.learn.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.learn.dto.VisitorDTO;
import com.microservice.learn.entity.Visitor;
import com.microservice.learn.service.VisitorService;
import com.microservice.learn.utils.ApiBaseResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VisitorController {

	private final VisitorService visitorService;
	
	@PostMapping("/visitor/create")
	public ResponseEntity<ApiBaseResponse<Visitor>> createdVisitor(@RequestBody VisitorDTO visitorDTO) {
		return ResponseEntity.ok(visitorService.enterNewVisitor(visitorDTO));
	}
	
	@GetMapping("/visitor/all")
	public ResponseEntity<ApiBaseResponse<List<Visitor>>> getAllVisitor() {
		return ResponseEntity.ok(visitorService.getAllVisitor());
	}
	
	@GetMapping("/visitor/{id}")
	public ResponseEntity<ApiBaseResponse<Visitor>> getAllVisitor(@PathVariable String id) {
		return ResponseEntity.ok(visitorService.getVisitorById(id));
	}
	
	@DeleteMapping("/visitor/delete/{id}")
	public ResponseEntity<ApiBaseResponse<Visitor>> deleteVisitorById(@PathVariable String id) {
		return ResponseEntity.ok(visitorService.deleteVisitoById(id));
	}
	
	@GetMapping("/visitor/pagination")
	public ResponseEntity<Page<Visitor>> getVisitorByPagination(Pageable p) {
		return ResponseEntity.ok(visitorService.listVisitorPagination(p));
	}
	
}
