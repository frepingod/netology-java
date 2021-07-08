package ru.netology.core.homework09.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Nasa {

    private final String copyright;
    private final Date date;
    private final String explanation;
    private final String hdurl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

    public Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public Date getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
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
                "\tcopyright='" + copyright + "'\n" +
                "\tdate='" + date + "'\n" +
                "\texplanation='" + explanation + "'\n" +
                "\thdurl='" + hdurl + "'\n" +
                "\tmediaType='" + mediaType + "'\n" +
                "\tserviceVersion='" + serviceVersion + "'\n" +
                "\ttitle='" + title + "'\n" +
                "\turl='" + url + "'\n" +
                "}";
    }
}