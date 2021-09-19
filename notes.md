Spring Boot @PostConstruct : https://zetcode.com/springboot/postconstruct/

Spring Batch Tutorial: Batch Processing Made Easy with Spring:
https://www.toptal.com/spring/spring-batch-tutorial

All Tutorials/Guides from My Blog Website - Java Guides
https://github.com/RameshMF
https://github-wiki-see.page/m/RameshMF/spring-boot-developers-guide/wiki

Tasklet vs Step:
https://www.baeldung.com/spring-batch-tasklet-chunk

Tuto
https://gkemayo.developpez.com/tutoriels/java/tutoriel-sur-mise-oeuvre-spring-batch-avec-spring-boot/

A Quick Guide to Spring @Value @Autowired
https://www.baeldung.com/spring-value-annotation
https://www.baeldung.com/spring-autowire

Spring Boot Annotations and Java based config Notes
https://github.com/ZaiusDR/spring-boot-annotations-based

Spring Batch Pagination with JDBC-cursor-item-reader
https://medium.com/spring-boot-framework/spring-batch-pagination-with-jdbcpagingitemreader-8226855a53d

Mapping CSV file with multiline Strings to Java Object with Spring Batch
https://baldir.fr/posts/mapping-csv-file-with-multiline-strings-to-java-object-with-spring-batch/

CustomerFileLineTokenizer implements LineTokenizer:
---
https://github.com/Apress/def-guide-spring-batch/blob/master/Chapter07/src/main/java/com/example/Chapter07/batch/CustomerFileLineTokenizer.java

https://www.tabnine.com/code/java/methods/org.springframework.batch.item.file.transform.FixedLengthTokenizer/setColumns


jobParameters:
---
[BatchConfig.java](https://github.com/uesleilima/spring-boot-batch-integration-sample/blob/master/src/main/java/com/uesleilima/spring/batch/integration/config/BatchConfig.java)
````
	@Bean
	@StepScope
	public FlatFileItemReader<Entry> reader(
			@Value("file:///#{jobParameters['input.file.path']}") Resource resource) throws Exception {
````
[IntegrationConfig.java](https://github.com/uesleilima/spring-boot-batch-integration-sample/blob/ddadece16544ded2a7721d98dd64f7db724f4d06/src/main/java/com/uesleilima/spring/batch/integration/config/IntegrationConfig.java)
````	public JobLaunchRequest transformFileToRequest(File file) {
		log.info("Creating request");

		Job job = getJobByFileName(file);
		log.info("Job = " + job.getName());

		JobParametersBuilder paramsBuilder = new JobParametersBuilder();
		paramsBuilder.addDate("start.date", new Date());
		paramsBuilder.addString("input.file.path", file.getPath());

		log.info("Parameters = " + paramsBuilder.toString());

		JobLaunchRequest request = new JobLaunchRequest(job, paramsBuilder.toJobParameters());
		return request;
````
