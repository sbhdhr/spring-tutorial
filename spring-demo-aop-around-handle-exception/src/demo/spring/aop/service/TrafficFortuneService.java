package demo.spring.aop.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	private String getFortune() {

		Random random = new Random(System.currentTimeMillis());

		// simulate delay
		try {
			TimeUnit.SECONDS.sleep(random.nextInt(5));
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// return fortune
		return "Heavy traffic this morning";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Service not available!!");
		} else {
			return getFortune();
		}
	}
}
