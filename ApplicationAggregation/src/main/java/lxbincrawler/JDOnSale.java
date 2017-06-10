package lxbincrawler;

import java.util.ArrayList;

/**
 * Created by mm on 2017/6/10.
 */
public class JDOnSale {
    //首页获取的信息
    private String movieId;//电影id
    private String movieName;//电影名
    private Double score;//电影评分

    //详情页面获取的信息
    private String director;
    private ArrayList<String> actors;//主演
    private String tag;//标签
    private String introduction;//介绍
    private ArrayList<String> times;//时间段

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }
}
