package com.hieptran.smarthome_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean success;

    private String message;

    private T data;

    private String statusCode;

    private MetaData metaData;
}
