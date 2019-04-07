package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Answer;
import com.example.demo.domain.AnswerRepository;
import com.example.demo.domain.Question;
import com.example.demo.domain.QuestionRepository;



@SpringBootApplication
public class DemoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner lukkariKysely(QuestionRepository qRepo, AnswerRepository aRepo) {
		return (args) -> {
			log.info("Please tell rosie");

			//Questions
			qRepo.save(new Question("Minä vuonna aloitit opintosi Haaga-Heliassa?"));
			qRepo.save(new Question("Oletko käyttänyt lukkarikonetta?"));
			qRepo.save(new Question("Oletko kokenut lukkarikoneen toimivaksi?"));
			qRepo.save(new Question("Mitä hyvää lukkarikoneessa mielestäsi on?"));
			
			//Answers 
			aRepo.save(new Answer("2019"));
			aRepo.save(new Answer("2018"));
			aRepo.save(new Answer("Aiemmin"));
			
			aRepo.save(new Answer("Kyllä"));
			aRepo.save(new Answer("Ei"));
			aRepo.save(new Answer("En osaa sanoa"));
			
			aRepo.save(new Answer());
			
			
			log.info("Music is my best friend");
			for (Question question : qRepo.findAll()) {
				log.info(question.toString());
			}
		};
	}

}
