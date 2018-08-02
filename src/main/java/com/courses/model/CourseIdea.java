package com.courses.model;

import com.github.slugify.Slugify;

import java.util.*;

public class CourseIdea {
    private String slug;
    private String title;
    private String creator;
    private Set<String> voters;

    public CourseIdea(String title, String creator) {
        voters = new HashSet<>();
        this.title = title;
        this.creator = creator;
        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(title);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getSlug() {
        return slug;
    }

    public List<String> getVoters(){
        return new ArrayList<>(voters);
    }

    public boolean addVoter(String voterUserName){
        return voters.add(voterUserName);
    }

    public int getVoteCount(){
        return voters.size();
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseIdea that = (CourseIdea) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(creator, that.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, creator);
    }

}
