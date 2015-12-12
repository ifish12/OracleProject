package com.jac.cs.myapplication.async;

import java.util.List;


public interface AsyncResponse<T> {
    void onAsyncPostExecute(T result);
}
