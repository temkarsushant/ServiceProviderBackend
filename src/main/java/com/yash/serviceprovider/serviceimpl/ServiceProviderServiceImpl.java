package com.yash.serviceprovider.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	@Override
	public UserServices save(int rid, int cid, String reviews, String userrequest, Boolean isPayment) {

		Registration r = registrationDao.findById(rid).orElse(null);
		Categories c = categoriesDao.findById(cid).orElse(null);
		UserServices us = new UserServices();
		us.setFkcategoryid(c);
		us.setFkregistrationuserid(r);
		us.setIsPayment(isPayment);
		us.setReviews(reviews);
		us.setUserrequest(userrequest);
		System.out.println("-------" + r);

		return userServicesDao.save(us);
	}

	@Override
	public UserServices delete(int rid, int cid, String reviews, String userrequest, Boolean isPayment) {

		List<UserServices> us = userServicesDao.find(rid, cid, userrequest);

		for (UserServices usr : us) {
			userServicesDao.delete(usr);
		}
		return null;
	}

	@Override
	public String getUserServicesById(int rid) {
		System.out.println(rid);
		int totalPrice=0;
		String userrequest = "Pending";
		List<UserServices> us = userServicesDao.find(rid, userrequest);
		List<Categories> cc=new ArrayList<>();
		for(UserServices u:us) {
			Categories ccc=u.getFkcategoryid();
			cc.add(ccc);
		}
		for(Categories price:cc) {
			totalPrice=totalPrice+price.getPrice();
		}
		
		System.out.println(totalPrice);
		
		return totalPrice+"";
	}

	@Override
	@Transactional
	public String serUserpayment(int rid,Boolean isPayment) {
		userServicesDao.save(rid,isPayment);
		return "Succuss";
	}

}
