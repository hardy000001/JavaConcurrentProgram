package com.zeluli0518.concurrent;

public class Main {
	private static final long count = 1000000000;	//10亿
	public static void main(String[] args) throws InterruptedException {
		concurrent();
		serial();
	}
	
	private static void concurrent() throws InterruptedException {
		long start = System.currentTimeMillis();
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				long a = 0;
				for (long i = 0; i < count; i++) {
					a += 10;
				}
				long time = System.currentTimeMillis() - start;
				System.out.println("concurrent a time: " + time + "ms, a = " + a);
			}
		});
		thread.start();
		
		long b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		
		long time = System.currentTimeMillis() - start;
		
		thread.join();
		
		long allTime = System.currentTimeMillis() - start;
		System.out.println("concurrent all time: " + allTime + "ms, b time: " + time  + "ms, b = " + b + "\n");
	}
	
	private static void serial() {
		long start = System.currentTimeMillis();
		long a = 0;
		for (long i = 0; i < count; i++) {
			a += 10;
		}
		
		long b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		
		long time = System.currentTimeMillis() - start;
		System.out.println("serial all time: " + time + "ms, b = " + b + ", a = " + a);
	}

}
