
package com.example.kingj.messageapp.Pojos;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class VideosResult {

    @Expose
    private String id;
    @SerializedName("iso_3166_1")
    private String iso_3166_1;
    @SerializedName("iso_639_1")
    private String iso_639_1;
    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private String site;
    @Expose
    private Long size;
    @Expose
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso31661() {
        return iso_3166_1;
    }

    public void setIso31661(String iso31661) {
        this.iso_3166_1 = iso31661;
    }

    public String getIso6391() {
        return iso_639_1;
    }

    public void setIso6391(String iso6391) {
        this.iso_639_1 = iso6391;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
