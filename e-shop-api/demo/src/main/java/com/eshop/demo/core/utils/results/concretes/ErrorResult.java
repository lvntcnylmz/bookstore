package com.eshop.demo.core.utils.results.concretes;

import com.eshop.demo.core.utils.results.abstracts.Result;

public class ErrorResult extends Result {

    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
    
}
