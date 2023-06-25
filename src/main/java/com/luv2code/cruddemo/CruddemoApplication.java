package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//System.out.println("Hello World");
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			removeInstructor(appDAO);
//			findInstructorDetail(appDAO);
			removeInstructorDetail(appDAO);
		};
	}



	private void findInstructorDetail(AppDAO appDAO) {
		//get the instructor detail object
		int theId = 3;
		InstructorDetail tempInstructorDetail  =appDAO.findInstructorDetailById(theId);
		//print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);

		//print the associated instructor
		System.out.println("the associated instructor: "+tempInstructorDetail.getInstructor());

		System.out.println("Done!");

	}

	private void removeInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);

	}

	private void removeInstructorDetail(AppDAO appDAO) {
		int theId = 4;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		//create the instructor
		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Luv 2 code");


		/*//create the instructor
		Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://www.luv2code.com/youtube",
				"Guitar");*/

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//NOTE: this will also save the details object
		// because of CascadeType.ALL
		System.out.println("Saving instructor: "+tempInstructor);

		appDAO.save(tempInstructor);

	}

}
