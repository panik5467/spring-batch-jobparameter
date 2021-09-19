package com.javainuse.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.javainuse.GlobalValue;

@Configuration
public class JobConfiguration {

	@Autowired
	private GlobalValue globalValue ;

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	@StepScope
	public Tasklet helloWorldTasklet(@Value("#{jobParameters['message']}") String message) {
		return (stepContribution, chukContext) -> {
			globalValue.GLOBALSET.add("*** STEP-1 ***");
			System.out.printf("\t Executing Tasklet with BEAN parameter: %s %n",globalValue.GLOBALSET);
			//System.out.println(message);
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	@StepScope
	public Tasklet tasklet2() {
		return (stepContribution, chukContext) -> {
			if (!globalValue.GLOBALSET.contains("*** STEP-2 ***"))
				globalValue.GLOBALSET.add("*** STEP-2 ***");
			else
				globalValue.GLOBALSET.add("*** STEP-3 ***");
			System.out.printf("\t Executing Tasklet with BEAN parameter: %s %n",globalValue.GLOBALSET);
			//System.out.println(message);
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").tasklet(helloWorldTasklet(null)).build();
	}

	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2").tasklet(tasklet2()).build();
	}

	@Bean
	public Job jobParametersJob() {
		return jobBuilderFactory.get("jobParametersJob").start(step1()).next(step2()).next(step2()).build();
	}
}