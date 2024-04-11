package com.choongang.campick.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.choongang.campick.service.DustService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class DustController {
	private final DustService service;
	
	@Scheduled(cron = "0 0 18 * * *")
	@GetMapping("dustinsert")
	public void dustinsert() throws Exception {
		service.dustinsert();
		System.out.println("성공");
	}
}
