# spring-batch-jobparameter

Understand Job Context and Step Context
  [Passing Data to Future Steps](https://docs.spring.io/spring-batch/docs/4.3.x/reference/html/common-patterns.html#passingDataToFutureSteps)

Added global variables in GlobalValue class

- https://www.javainuse.com/spring/batchtaskchunk
- https://www.javainuse.com/spring/batch/jobparam

```diff

2021-09-19 15:17:56.994  INFO 1428 --- [           main] com.javainuse.JobParametersApplication   : No active profile set, falling back to default profiles: default
2021-09-19 15:17:58.047  INFO 1428 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2021-09-19 15:17:58.224  INFO 1428 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2021-09-19 15:17:58.249  INFO 1428 --- [           main] o.s.b.c.r.s.JobRepositoryFactoryBean     : No database type set, using meta data indicating: H2
2021-09-19 15:17:58.572  INFO 1428 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : No TaskExecutor has been set, defaulting to synchronous executor.
2021-09-19 15:17:58.859  INFO 1428 --- [           main] com.javainuse.JobParametersApplication   : Started JobParametersApplication in 2.193 seconds (JVM running for 6.805)
2021-09-19 15:17:58.937  INFO 1428 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=jobParametersJob]] launched with the following parameters: [{message=MyHello, date=1632057478859, time=1632057478859}]
2021-09-19 15:17:58.953  INFO 1428 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step1]
@@ Executing Tasklet with BEAN parameter: [*** STEP-1 ***, * init *] @@
2021-09-19 15:17:59.051  INFO 1428 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step2]
@@ Executing Tasklet with BEAN parameter: [*** STEP-1 ***, * init *, *** STEP-2 ***] @@
2021-09-19 15:17:59.098  INFO 1428 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Duplicate step [step2] detected in execution of job=[jobParametersJob]. If either step fails, both will be executed again on restart.
2021-09-19 15:17:59.098  INFO 1428 --- [           main] o.s.batch.core.job.SimpleStepHandler     : Executing step: [step2]
@@ Executing Tasklet with BEAN parameter: [*** STEP-1 ***, * init *, *** STEP-2 ***, *** STEP-3 ***] @@
2021-09-19 15:17:59.113  INFO 1428 --- [           main] o.s.b.c.l.support.SimpleJobLauncher      : Job: [SimpleJob: [name=jobParametersJob]] completed with the following parameters: [{message=MyHello, date=1632057478859, time=1632057478859}] and the following status: [COMPLETED]
STATUS :: COMPLETED
[INFO] ------------------------------------------------------------------------
