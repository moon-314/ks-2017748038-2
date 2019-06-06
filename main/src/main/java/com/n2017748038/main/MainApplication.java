package com.n2017748038.main;

import com.n2017748038.main.domain.Basic;
import com.n2017748038.main.domain.Profile;
import com.n2017748038.main.repository.BasicRepository;
import com.n2017748038.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(BasicRepository basicRepository, ProfileRepository profileRepository) {
		return (args) -> {
					basicRepository.save(Basic.builder()
							.name("홍길동")
							.label("CEO")
							.email("hone@gmail.com")
							.phone("012-123-4567")
							.build());

					basicRepository.save(Basic.builder()
					.name("장길산")
					.label("CFO")
					.email("jang@gmail.com")
					.phone("123-456-7890")
					.build());

					basicRepository.save(Basic.builder()
					.name("춘향이")
					.label("CTO")
					.email("chun@gmail.com")
					.phone("234-567-8901")
					.build());

			IntStream.rangeClosed(1, 5).forEach(index ->
					basicRepository.save(Basic.builder()
							.name("이름" + index)
							.label("직책")
							.email("이메일")
							.phone("연락처")
							.build()));

					profileRepository.save(Profile.builder()
							.network("트위터")
							.username("@home")
							.url("https://www.twitter.com/@home")
							.createdAt(LocalDateTime.now())
							.build());

					profileRepository.save(Profile.builder()
							.network("페이스북")
							.username("@home")
							.url("https://www.facebook.com/@home")
							.createdAt(LocalDateTime.now())
							.build());

					profileRepository.save(Profile.builder()
							.network("인스타그램")
							.username("@home")
							.url("https://www.instargram.com/@home")
							.createdAt(LocalDateTime.now())
							.build());

			IntStream.rangeClosed(1, 5).forEach(index ->
					profileRepository.save(Profile.builder()
							.network("SNS" + index)
							.username("ID")
							.url("링크")
							.createdAt(LocalDateTime.now())
							.build()));
		};
	}
}
