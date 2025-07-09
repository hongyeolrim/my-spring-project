package com.yedam.app.upload.config;

public interface CommonInterface {
	public void printMsg();

	public default Integer plus(int x, int y) {
		return x + y;
	}
}
