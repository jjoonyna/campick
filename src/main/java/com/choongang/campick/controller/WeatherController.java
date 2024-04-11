package com.choongang.campick.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.choongang.campick.model.Weather;
import com.choongang.campick.service.WeatherService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class WeatherController {
	private final WeatherService service;
	
	@Scheduled(cron = "0 0 18 * * *")
	@GetMapping("weatherinsert")
	public void weatherinsert() throws Exception {
		service.weatherinsert();
		System.out.println("성공");
	}
}
