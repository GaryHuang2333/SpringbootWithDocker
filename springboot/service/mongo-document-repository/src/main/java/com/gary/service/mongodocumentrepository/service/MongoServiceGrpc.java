package com.gary.service.mongodocumentrepository.service;

import com.gary.library.grpc.interfacemongo.MongoRepoServiceGrpc;
import com.gary.library.grpc.interfacemongo.StringRequest;
import com.gary.library.grpc.interfacemongo.StringResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.Optional;

@GrpcService
public class MongoServiceGrpc extends MongoRepoServiceGrpc.MongoRepoServiceImplBase{
    @Override
    public void hello(StringRequest request, StreamObserver<StringResponse> responseObserver) {
        String response = "Hello to " + Optional.ofNullable(request.getName()).orElse("EmptyName") + " from " + this.getClass().getSimpleName();
        StringResponse stringResponse = StringResponse.newBuilder().setResult(response).build();
        responseObserver.onNext(stringResponse);
        responseObserver.onCompleted();
    }
}
