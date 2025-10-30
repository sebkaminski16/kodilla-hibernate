package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SearchingFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByFragment(String fragment) {
        String pattern = "%" + fragment + "%";
        return companyDao.retrieveCompaniesWithNameLike(pattern);
    }

    public List<Employee> findEmployeesByFragment(String fragment) {
        String pattern = "%" + fragment + "%";
        return employeeDao.retrieveEmployeesWithLastnameLike(pattern);
    }
}
