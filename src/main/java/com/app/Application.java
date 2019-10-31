package com.app;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.app.model.Pemegang;
import com.app.model.Tertanggung;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application  implements CommandLineRunner  {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("problem...");
		
		HashMap<String,Object> params = new HashMap<String, Object>();
		
		params.put("pemegang", new Pemegang());
		params.put("tertanggung",new Tertanggung());
		
		String key = "pemegang";
		
		PropertyUtils.setSimpleProperty(params.get("pemegang"),"firstName","Patar Timotius");

		PropertyUtils.setSimpleProperty(params.get("pemegang"),"lastName","LastName");
		
		PropertyUtils.setSimpleProperty(params.get("pemegang"),"age",20);
		PropertyUtils.setSimpleProperty(params.get("pemegang"),"salary",new Double(20000));
		PropertyUtils.setSimpleProperty(params.get("pemegang"),"dateOfBirth",new Date());
		
		System.out.println(((Pemegang)params.get("pemegang")).getFirstName());
		System.out.println(ToStringBuilder.reflectionToString(params.get("pemegang")));	
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	};
	
}