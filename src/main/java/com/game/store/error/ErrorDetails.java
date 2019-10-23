package com.game.store.error;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author malves
 * 
 *         Erro original do spring
 * 
 *         { "timestamp": "2019-10-09T19:08:42.345+0000", "status": 400,
 *         "error": "Bad Request", "errors": [ { "codes": [
 *         "NotEmpty.object.name", "NotEmpty.name", "NotEmpty.java.lang.String",
 *         "NotEmpty" ], "arguments": [ { "codes": [ "object.name", "name" ],
 *         "arguments": null, "defaultMessage": "name", "code": "name" } ],
 *         "defaultMessage": "Por favor forneça o nome", "objectName": "object",
 *         "field": "name", "rejectedValue": "", "bindingFailure": false,
 *         "code": "NotEmpty" } ], "message": "Validation failed for
 *         object='object'. Error count: 1", "path": "/uri" }
 */
public class ErrorDetails {

    @ApiModelProperty(name = "timestamp")
    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private String timestamp;

    @ApiModelProperty(name = "status")
    @JsonProperty("status")
    private int status;

    @ApiModelProperty(name = "error")
    @JsonProperty("error")
    private String error;

    @ApiModelProperty(name = "errors")
    @JsonProperty("errors")
    private Map<String, String> errors;

    @ApiModelProperty(name = "path")
    @JsonProperty("path")
    private String path;

    @ApiModelProperty(name = "version")
    @JsonProperty("version")
    private String version;

    public ErrorDetails(String timestamp, int status, String error, Map<String, String> errors) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.errors = errors;
    }

    public ErrorDetails(String timestamp, int status, String error, Map<String, String> errors, String path,
            String version) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.errors = errors;
        this.path = path;
        this.version = version;
    }

    /**
     * @return Date return the timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return int return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return Map<String, String> return the errors
     */
    public Map<String, String> getErrors() {
        return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    /**
     * @return String return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return String return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

}