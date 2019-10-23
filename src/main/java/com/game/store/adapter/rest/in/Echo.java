package com.game.store.adapter.rest.in;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author malves
 */
public class Echo {

    @ApiModelProperty(name = "id")
    @JsonProperty("id")
    private long id;

    @ApiModelProperty(name = "content")
    @JsonProperty("content")
    private String content;

    public Echo() {

    }

    public Echo(long id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

}
