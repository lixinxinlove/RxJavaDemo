package com.love.rxjavademo.bean;

import java.util.List;

/**
 * Created by android on 2017/9/21.
 */

public class Result {


    private boolean error;
    private List<Girl> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Girl> getResults() {
        return results;
    }

    public void setResults(List<Girl> results) {
        this.results = results;
    }

}
