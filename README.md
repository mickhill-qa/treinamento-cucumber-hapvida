Configuração do Projeto de Testes
=======================
BDD + Java + Cucumber + Selenium.


**Criar Projeto no Eclipse**
- File > New > Maven Project



**Instalação de plugin na IDE**
- Help > Eclipse Marketplace > [Cucumber Eclipse Plugin](http://marketplace.eclipse.org/content/cucumber-eclipse-plugin)



**Instalar pacotes na Aplicação via Maven (pom.xml)**
- cucumber-java 1.2.5
- cucumber-junit 1.2.5
- selenium-java 3.141.59

**pom.xml**
```
<dependencies>
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-java</artifactId>
		<version>1.2.5</version>
	</dependency>
	<dependency>
		<groupId>info.cukes</groupId>
		<artifactId>cucumber-junit</artifactId>
		<version>1.2.5</version>
		<scope>test</scope>
	</dependency>
	<dependency>
		<groupId>org.seleniumhq.selenium</groupId>
		<artifactId>selenium-java</artifactId>
		<version>3.141.59</version>
	</dependency>
</dependencies>
```