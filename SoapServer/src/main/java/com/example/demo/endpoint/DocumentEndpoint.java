package com.example.demo.endpoint;

import com.example.demo.CheckSumSha.FileCheckSumSHA;
import com.example.demo.generatedFiles.StoreDocumentRequest;
import com.example.demo.generatedFiles.StoreDocumentResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Endpoint
public class DocumentEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "storeDocumentRequest")
    @ResponsePayload
    public StoreDocumentResponse storeDocument(
            @RequestPayload StoreDocumentRequest request) throws IOException, NoSuchAlgorithmException {
        byte[] data = request.getDocument();

        if(data!=null){
        System.out.println(String.format("received %d bytes", data.length));
        StoreDocumentResponse response = new StoreDocumentResponse();
        String a=FileCheckSumSHA.SHAsum(data);
        response.setSha(a);
        return response;}


        return null;
    }
}
