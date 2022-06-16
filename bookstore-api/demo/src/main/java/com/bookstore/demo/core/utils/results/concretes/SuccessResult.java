package com.bookstore.demo.core.utils.results.concretes;

import com.bookstore.demo.core.utils.results.abstracts.Result;

public class SuccessResult extends Result {

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
    
}
