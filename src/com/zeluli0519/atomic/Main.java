package com.zeluli0519.atomic;

public class Main {
	class VolatileFeaturesExample {
		volatile long v1 = 0L;
		public void setV1(long v1) {
			this.v1 = v1;
		}
		
		public long getV1() {
			return v1;
		}
		
		public void increment() {
			v1++;
		}
	}

	public static void main(String[] args) {
	}

}

