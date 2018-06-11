package com.feliphe.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map to Java Object
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

			System.out.println(student.getFirstName() + " " + student.getLastName() + "\n");
			System.out.println(student.getAddress().getStreet());
			System.out.println(student.getAddress().getCity());
			System.out.println(student.getAddress().getCountry());

			for (String language : student.getLanguages()) {
				System.out.println(language);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
