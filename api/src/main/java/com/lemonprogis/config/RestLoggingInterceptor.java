package com.lemonprogis.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestLoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RestLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest httpRequest,
            byte[] bytes,
            ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

        // log request
        traceRequest(httpRequest, bytes);

        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);

        // log response
        //traceResponse(response);

        return response;
    }

    /**
     * Trace our Request before going out on wire
     *
     * @param request
     * @param body
     * @throws IOException
     */
    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
        logger.info("===========================request begin================================================");
        logger.info("URI         : {}", request.getURI());
        logger.info("Method      : {}", request.getMethod());
        logger.info("Headers     : {}", request.getHeaders() );
        logger.info("Request body: {}", new String(body, "UTF-8"));
        logger.info("==========================request end================================================");
    }

    /**
     * Trace Response of our REST Request
     *
     * @param response
     * @throws IOException
     */
    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        logger.info("============================response begin==========================================");
        logger.info("Status code  : {}", response.getStatusCode());
        logger.info("Status text  : {}", response.getStatusText());
        logger.info("Headers      : {}", response.getHeaders());
        logger.info("Response body: {}", inputStringBuilder.toString());
        logger.info("=======================response end=================================================");
    }
}
