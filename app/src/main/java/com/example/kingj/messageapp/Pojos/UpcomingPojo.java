
package com.example.kingj.messageapp.Pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class UpcomingPojo {

    @Expose
    private UpcomingDates upcoming_dates;
    @Expose
    private Long page;
    @Expose
    private List<UpcomingResult>results;
    @SerializedName("total_pages")
    private Long total_pages;
    @SerializedName("total_results")
    private Long total_results;

    public UpcomingDates getUpcomingDates() {
        return upcoming_dates;
    }

    public void setUpcomingDates(UpcomingDates upcomingDates) {
        this.upcoming_dates = upcomingDates;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<UpcomingResult> getResults() {
        return results;
    }

    public void setResults(List<UpcomingResult> upcomingResults) {
        this.results = upcomingResults;
    }

    public Long getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(Long totalPages) {
        this.total_pages = totalPages;
    }

    public Long getTotalResults() {
        return total_results;
    }

    public void setTotalResults(Long totalResults) {
        this.total_results = totalResults;
    }

}
