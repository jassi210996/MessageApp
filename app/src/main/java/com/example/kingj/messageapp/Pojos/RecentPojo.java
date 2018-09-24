
package com.example.kingj.messageapp.Pojos;

import com.example.kingj.messageapp.Fragments.Recent;

import java.util.List;

public class RecentPojo {

    private RecentDates recent_dates;

    private Long page;

    private List<RecentResult> results;

    private Long total_pages;

    private Long total_results;

    public RecentDates getRecentDates() {
        return recent_dates;
    }

    public void setRecentDates(RecentDates recentDates) {
        this.recent_dates = recentDates;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<RecentResult> getRecentResults() {
        return results;
    }

    public void setRecentResults(List<RecentResult> recentResults) {
        this.results = recentResults;
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
