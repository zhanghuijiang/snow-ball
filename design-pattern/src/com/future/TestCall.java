package com.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestCall {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new RealDataCall("name"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);
        System.out.println(future.get());
        executor.shutdown();
	}

}
