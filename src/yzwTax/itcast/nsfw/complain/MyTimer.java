package yzwTax.itcast.nsfw.complain;

import java.util.Timer;

public class MyTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Timer timer = new Timer();

		timer.schedule(new MyTimerTask(), 2000, 3000);
	}

}
