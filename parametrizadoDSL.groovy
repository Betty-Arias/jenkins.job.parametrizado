job('ejemplo2-job-DSL') {
	description('Job DSL de ejemplo para el curso de Jenkins')
  	scm {
      		git('https://github.com/Betty-Arias/jenkins.job.parametrizado.git', 'main') { node ->
        		node / gitConfigName('Betty-Arias')
        		node / gitConfigEmail('bttyloha@gmail.com')
      		}
    	} 
  	parameters {
   		stringParam('nombre', defaultValue = 'Julian', description = 'Parametro de cadena para el Job Booleano')
      		choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
      		booleanParam('agente', false)
    	}
  	triggers {
    		cron('H/7 * * * *')
    	}
  	steps {
    		shell("bash jobscript.sh")
    	}
  	publishers {
      		mailer('bettyarias3030@gmail.com', true, true)
    	}
}