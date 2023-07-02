package runner;

import org.junit.AfterClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import com.rajatthareja.reportbuilder.ReportBuilder;
import com.rajatthareja.reportbuilder.Color;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",	            // Path: features = "classpath:features"
        glue = "steps_definition",					            // Path: Steps
        monochrome = false,							            // Cores no Terminal default: false
        snippets = CucumberOptions.SnippetType.UNDERSCORE,		// METHODOS do Steps em CAMELCASE
        dryRun = false,								            // Validar Steps sem executar o teste
        plugin = {									            // Plugins Cucumber para possivel integracao com Jenkins
                "pretty",
                "html:target/cucumber/index.html",
                "junit:target/cucumber/index.xml",
                "json:target/cucumber/index.json"
        }
        //,tags = { "@tagScenario" }

        /**
         * Executar testes no termial
         *
         *	$ mvn test
         *	$ mvn test -Dcucumber.options="--tags @tagScenario"
         *
         *	$ mvn clean
         *	$ mvn clean test
         *
         *
         * Gerar Relatorio Cucumber localmente
         *
         *	$ mvn verify -DskipTests
         *	$ mvn test verify
         *	$ mvn clean test verify
         *	$ mvn clean test -Dcucumber.options="--tags @tagScenario" verify
         * */
)

public class RunCucumberTest {
        @AfterClass
        public static void writeExtentReport() {
                // https://reportbuilderjava.rajatthareja.com/
                List<Object> cucumberJsonReports = new ArrayList<>();
                ReportBuilder reportBuilder = new ReportBuilder();

                cucumberJsonReports.add(new File("target/cucumber/index.json"));
                reportBuilder.setReportDirectory("target/report-builder/");
                reportBuilder.setReportFileName("index");
                reportBuilder.setReportColor(Color.PURPLE); // http://materializecss.com/color.html
                reportBuilder.setReportTitle("treinamento_cucumber_hapvida");
                reportBuilder.setAdditionalInfo("Date", (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date()));
                reportBuilder.setAdditionalInfo("Environment", "N/A");
                reportBuilder.setAdditionalInfo("Browser", "");
                reportBuilder.setAdditionalInfo("Url", "");
                reportBuilder.setAdditionalInfo("Runtime", "");
                reportBuilder.build(cucumberJsonReports);
        }
}
