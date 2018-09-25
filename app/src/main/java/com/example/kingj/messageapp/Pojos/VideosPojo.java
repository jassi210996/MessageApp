
package com.example.kingj.messageapp.Pojos;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class VideosPojo {

    @Expose
    private Long id;
    @Expose
    private List<VideosResult> results;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VideosResult> getResults() {
        return results;
    }

    public void setResults(List<VideosResult> results) {
        this.results = results;
    }

}
