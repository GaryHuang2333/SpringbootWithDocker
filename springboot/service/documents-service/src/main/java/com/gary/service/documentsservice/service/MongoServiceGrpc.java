package com.gary.service.documentsservice.service;

import com.gary.library.grpcinterface.mongo.MongoRepoProto;
import com.gary.library.grpcinterface.mongo.MongoRepoServiceGrpc;
import com.gary.library.grpcinterface.mongo.StringRequest;
import com.gary.library.grpcinterface.mongo.StringResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class MongoServiceGrpc {
    @GrpcClient("mongo-document-repository")
    private MongoRepoServiceGrpc.MongoRepoServiceBlockingStub serviceBlockingStub;

    public String sayHello(String name){
        MongoRepoServiceGrpc.MongoRepoServiceBlockingStub stub = serviceBlockingStub;
        StringRequest stringRequest = StringRequest.newBuilder().setName(name).build();
        StringResponse stringResponse1 = serviceBlockingStub.hello(stringRequest);
        StringResponse stringResponse2 = stub.hello(stringRequest);
        return stringResponse1.getResult();
//        return stringResponse2.getResult();
    }
}
