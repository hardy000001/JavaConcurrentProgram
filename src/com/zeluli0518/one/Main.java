package com.zeluli0518.one;

public class Main {
	private static final long count = 100000000;
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
			}
		});
		thread.start();
		
		long b = 0;
		for (long i = 0; i < count; i++) {
			b--;
		}
		
		long time = System.currentTimeMillis() - start;
		thread.join();
		System.out.println("concurrent : " + time + "ms, b = " + b);
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
		System.out.println("concurrent : " + time + "ms, b = " + b + " a = " + a);
	}

}
