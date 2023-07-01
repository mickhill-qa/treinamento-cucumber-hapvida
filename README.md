Configuração do Projeto de Testes
=======================
BDD + Java + Cucumber + Selenium.


**Criar Projeto no Eclipse**
- File > New > Maven Project



**Instalação de plugin na IDE**
- Help > Eclipse Marketplace > [Cucumber Eclipse Plugin](http://marketplace.eclipse.org/content/cucumber-eclipse-plugin)



**Instalar pacotes na Aplicação via Maven (pom.xml)**
- cucumber-java 7.2.3
- cucumber-junit 7.2.3
- selenium-java 3.141.59
- webdrivermanager 5.0.3

**pom.xml**
```
<dependencies>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.2.3</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-junit</artifactId>
        <version>7.2.3</version>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.0.3</version>
    </dependency>
</dependencies>
```