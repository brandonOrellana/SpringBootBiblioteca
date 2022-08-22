package com.example.biblioteca.client.config;

import com.example.biblioteca.exception.FeignClientException;
import com.example.biblioteca.exception.config.GlobalErrorCode;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignCustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new FeignClientException("Bad Request Through Feign", GlobalErrorCode.ERROR_FEIGN_CLIENT);
            case 401:
                return new FeignClientException("Unauthorized Request Through Feign", GlobalErrorCode.ERROR_FEIGN_CLIENT);
            case 404:
                return new FeignClientException("Unidentified Request Through Feign", GlobalErrorCode.ERROR_FEIGN_CLIENT);
            default:
                return new FeignClientException("Common Feign Exception", GlobalErrorCode.ERROR_FEIGN_CLIENT);
        }
    }
}
