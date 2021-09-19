package com.javainuse;

import java.util.Date;
import java.util.*;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JobParametersApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(JobParametersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 // Pass the required Job Parameters from here to read it anywhere within Spring Batch infrastructure
		JobParameters jobParameters = new JobParametersBuilder().addString("message", "MyHello").addDate("date", new Date())
                .addLong("time",System.currentTimeMillis()).toJobParameters();
		
		JobExecution execution = jobLauncher.run(job, jobParameters );
		System.out.println("STATUS :: "+execution.getStatus());
	}
}