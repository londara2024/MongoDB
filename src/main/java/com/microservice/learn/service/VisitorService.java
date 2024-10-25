package com.microservice.learn.service;

import java.util.List;

import com.microservice.learn.dto.VisitorDTO;
import com.microservice.learn.entity.Visitor;
import com.microservice.learn.utils.ApiBaseResponse;

public interface VisitorService {
	ApiBaseResponse<Visitor> enterNewVisitor (VisitorDTO visitorDTO);
	ApiBaseResponse<List<Visitor>> getAllVisitor ();
	ApiBaseResponse<Visitor> getVisitorById (String Id);
	ApiBaseResponse<Visitor> deleteVisitoById (String Id);
}
