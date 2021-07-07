package ru.netology.core.homework09.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Nasa {

    private final Date date;
    private final String explanation;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

    public Nasa(
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.date = date;
        this.explanation = explanation;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Nasa{\n" +
                "\tdate='" + date + "'\n" +
                "\texplanation='" + explanation + "'\n" +
                "\tmediaType='" + mediaType + "'\n" +
                "\tserviceVersion='" + serviceVersion + "'\n" +
                "\ttitle='" + title + "'\n" +
                "\turl='" + url + "'\n" +
                "}";
    }
}