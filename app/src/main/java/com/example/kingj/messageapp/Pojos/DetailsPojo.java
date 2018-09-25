
package com.example.kingj.messageapp.Pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DetailsPojo {

    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("belongs_to_collection")
    private Object belongs_to_collection;
    @Expose
    private Long budget;
    @Expose
    private List<DetailsGenre> genres;
    @Expose
    private String homepage;
    @Expose
    private Long id;
    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("original_title")
    private String original_title;
    @Expose
    private String overview;
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("production_companies")
    private List<DetailsProductionCompany> production_companies;
    @SerializedName("production_countries")
    private List<DetailsProductionCountry> production_countries;
    @SerializedName("release_date")
    private String release_date;
    @Expose
    private Long revenue;
    @Expose
    private Long runtime;
    @SerializedName("spoken_languages")
    private List<DetailsSpokenLanguage> spoken_languages;
    @Expose
    private String status;
    @Expose
    private String tagline;
    @Expose
    private String title;
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    private Double vote_average;
    @SerializedName("vote_count")
    private Long vote_count;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    public Object getBelongsToCollection() {
        return belongs_to_collection;
    }

    public void setBelongsToCollection(Object belongsToCollection) {
        this.belongs_to_collection = belongsToCollection;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public List<DetailsGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<DetailsGenre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdb_id;
    }

    public void setImdbId(String imdbId) {
        this.imdb_id = imdbId;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public List<DetailsProductionCompany> getProductionCompanies() {
        return production_companies;
    }

    public void setProductionCompanies(List<DetailsProductionCompany> productionCompanies) {
        this.production_companies = productionCompanies;
    }

    public List<DetailsProductionCountry> getProductionCountries() {
        return production_countries;
    }

    public void setProductionCountries(List<DetailsProductionCountry> productionCountries) {
        this.production_countries = productionCountries;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        this.runtime = runtime;
    }

    public List<DetailsSpokenLanguage> getSpokenLanguages() {
        return spoken_languages;
    }

    public void setSpokenLanguages(List<DetailsSpokenLanguage> spokenLanguages) {
        this.spoken_languages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(Double voteAverage) {
        this.vote_average = voteAverage;
    }

    public Long getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(Long voteCount) {
        this.vote_count = voteCount;
    }

}
