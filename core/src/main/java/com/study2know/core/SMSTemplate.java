package com.study2know.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel
public class SMSTemplate {

    @JsonProperty
    private Long id;
    @NotBlank
    @Size(max = 10)
    @JsonProperty
    private String senderId;
    @JsonProperty
    private String category;
    @NotBlank
    @Size(max = 5000)
    @JsonProperty
    private String template;
    @NotBlank
    @Size(max = 1000)
    @JsonProperty
    private String params;
    @JsonProperty
    private Date lastUpdated;
    @NotBlank
    @Size(max = 200)
    @JsonProperty
    private String smsEvent;
    @Size(max = 5)
    @JsonProperty
    private String delimiter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getSmsEvent() {
        return smsEvent;
    }

    public void setSmsEvent(String smsEvent) {
        this.smsEvent = smsEvent;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public String toString() {
        return "id:" + id + ",senderId:" + senderId + ",category:" + category + ",template:" + template + ",params:" + params + ",lastUpdated:" + lastUpdated + ",smsEvent:" + smsEvent + ",delimiter:" + delimiter;
    }
}


