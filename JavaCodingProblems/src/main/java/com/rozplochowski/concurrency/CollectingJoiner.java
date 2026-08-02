package com.rozplochowski.concurrency;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.StructuredTaskScope;

public class CollectingJoiner<T> implements StructuredTaskScope.Joiner<T, CollectingJoiner.Result<T>> {
    private final Queue<T> results = new ConcurrentLinkedQueue<>();
    private final Queue<Throwable> exceptions = new ConcurrentLinkedQueue<>();

    @Override
    public Result<T> result() {
        return new Result<>(List.copyOf(results), List.copyOf(exceptions));
    }

    @Override
    public boolean onComplete(StructuredTaskScope.Subtask<T> subtask) {
        switch (subtask.state()) {
            case SUCCESS -> results.add(subtask.get());
            case FAILED -> exceptions.add(subtask.exception());
            case UNAVAILABLE -> exceptions.add(new RuntimeException("Task unavailable"));
        }

        return false;
    }

    public record Result<T>(List<T> successes, List<Throwable> exceptions) { }
}
