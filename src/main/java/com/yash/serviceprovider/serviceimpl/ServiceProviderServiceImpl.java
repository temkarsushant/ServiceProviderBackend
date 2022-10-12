package com.yash.serviceprovider.serviceimpl;

import java.util.List;
import java.util.Optional;

import com.yash.serviceprovider.dao.AddressDao;
import com.yash.serviceprovider.dao.CategoriesDao;
import com.yash.serviceprovider.dao.RegistrationDao;
import com.yash.serviceprovider.dao.ServiceProviderDao;
import com.yash.serviceprovider.dao.UserServicesDao;
import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.entity.ServiceProvider;
import com.yash.serviceprovider.entity.UserServices;
import com.yash.serviceprovider.pojo.ServiceProviderPojo;
import com.yash.serviceprovider.service.ServiceProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	RegistrationDao registrationDao;

	@Autowired
	ServiceProviderDao serviceProviderDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	CategoriesDao categoriesDao;

	@Autowired
	UserServicesDao userServicesDao;

	@Override
	public Registration save(Registration rr) {
		return registrationDao.save(rr);
	}

	@Override
	public Registration getLoginDetails(String emailid) {
		return registrationDao.getByEmailid(emailid);
	}

	@Override
	public ServiceProvider save(ServiceProvider serviceProvider) {
		return serviceProviderDao.save(serviceProvider);
	}

	@Override
	public Address save(Address address) {
		return addressDao.save(address);
	}

	@Override
	public Categories save(Categories categories) {

		return categoriesDao.save(categories);
	}

	@Override
	public List<ServiceProvider> getServiceProviders() {
		return serviceProviderDao.findAll();
	}

	@Override
	public List<Categories> getServiceProvidersCategories(ServiceProviderPojo serviceProvider) {
		return categoriesDao.findAllByServiceProviderAndAddress(serviceProvider.getSid(), serviceProvider.getAid());
	}

	@Override
	public List<Address> getAddress() {
		return addressDao.findAll();
	}

	@Override
	public UserServices save(UserServices userServices) {
		return userServicesDao.save(userServices);
	}

	@Override
	public List<UserServices> getUserServices() {
		return userServicesDao.findAll();
	}

}
