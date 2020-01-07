package com.example.altkamulassesignment.model;

import java.util.List;

public class Media {
    private String url;

    private String adx_keywords;

    private String column;

    private String section;

    private String byline;

    private String type;

    private String title;

    private String abs;

    private String published_date;

    private String source;

    private int id;

    private int asset_id;

    private int views;

    private String des_facet;

    private List<String> org_facet;

    private String per_facet;

    private List<String> geo_facet;

    private List<Media> media;

    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setAdx_keywords(String adx_keywords){
        this.adx_keywords = adx_keywords;
    }
    public String getAdx_keywords(){
        return this.adx_keywords;
    }
    public void setColumn(String column){
        this.column = column;
    }
    public String getColumn(){
        return this.column;
    }
    public void setSection(String section){
        this.section = section;
    }
    public String getSection(){
        return this.section;
    }
    public void setByline(String byline){
        this.byline = byline;
    }
    public String getByline(){
        return this.byline;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAbstract(String abs){
        this.abs = abs;
    }
    public String getAbstract(){
        return this.abs;
    }
    public void setPublished_date(String published_date){
        this.published_date = published_date;
    }
    public String getPublished_date(){
        return this.published_date;
    }
    public void setSource(String source){
        this.source = source;
    }
    public String getSource(){
        return this.source;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setAsset_id(int asset_id){
        this.asset_id = asset_id;
    }
    public int getAsset_id(){
        return this.asset_id;
    }
    public void setViews(int views){
        this.views = views;
    }
    public int getViews(){
        return this.views;
    }
    public void setDes_facet(String des_facet){
        this.des_facet = des_facet;
    }
    public String getDes_facet(){
        return this.des_facet;
    }
    public void setOrg_facet(List<String> org_facet){
        this.org_facet = org_facet;
    }
    public List<String> getOrg_facet(){
        return this.org_facet;
    }
    public void setPer_facet(String per_facet){
        this.per_facet = per_facet;
    }
    public String getPer_facet(){
        return this.per_facet;
    }
    public void setGeo_facet(List<String> geo_facet){
        this.geo_facet = geo_facet;
    }
    public List<String> getGeo_facet(){
        return this.geo_facet;
    }
    public void setMedia(List<Media> media){
        this.media = media;
    }
    public List<Media> getMedia(){
        return this.media;
    }
}
