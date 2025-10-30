package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SearchingFacadeTestSuite {

    @Autowired
    private SearchingFacade searchFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompaniesByFragment() {
        //arrange
        Company mikesoft = new Company("Mikesoft");
        Company somecompany = new Company("SomeCompany");
        Company othercompany = new Company("OtherCompany");

        companyDao.save(mikesoft);
        companyDao.save(somecompany);
        companyDao.save(othercompany);

        //act
        List<Company> result = searchFacade.findCompaniesByFragment("mpany");

        //assert
        Assertions.assertEquals(2, result.size());

        //cleanup
        companyDao.deleteById(mikesoft.getId());
        companyDao.deleteById(somecompany.getId());
        companyDao.deleteById(othercompany.getId());
    }

    @Test
    void testFindEmployeesByFragment() {
        //arrange
        Employee janKochanowski = new Employee("Jan", "Kochanowski");
        Employee adamMickiewicz = new Employee("Adam", "Mickiewicz");
        Employee boleslawPrus = new Employee("Boleslaw", "Prus");

        employeeDao.save(janKochanowski);
        employeeDao.save(adamMickiewicz);
        employeeDao.save(boleslawPrus);

        //act
        List<Employee> result = searchFacade.findEmployeesByFragment("wicz");

        //assert
        Assertions.assertEquals(1, result.size());

        //cleanup
        employeeDao.deleteById(janKochanowski.getId());
        employeeDao.deleteById(adamMickiewicz.getId());
        employeeDao.deleteById(boleslawPrus.getId());

    }
}
