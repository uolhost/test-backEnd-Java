package com.superherogame.cleonildo.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@JsonPropertyOrder({"status", "message", "timestamp"})
@AllArgsConstructor
public class ErrorInfo  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Instant timestamp;
    private final Integer status;
    private final String message;

}