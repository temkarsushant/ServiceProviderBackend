package com.yash.serviceprovider.service;

import java.util.List;

import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.entity.ServiceProvider;
import com.yash.serviceprovider.entity.UserServices;
import com.yash.serviceprovider.pojo.Login;
import com.yash.serviceprovider.pojo.RegisterServiceProviderPojo;
import com.yash.serviceprovider.pojo.ServiceProviderPojo;

public interface ServiceProviderService {

	Registration save(Registration rr);

	Registration getLoginDetails(String emailid);

	ServiceProvider save(ServiceProvider serviceProvider);

	Address save(Address address);

	Categories save(Categories categories);

	List<ServiceProvider> getServiceProviders();

	List<Categories> getServiceProvidersCategories(ServiceProviderPojo serviceProvider);

	List<Address> getAddress();

	UserServices save(UserServices userServices);

	List<UserServices> getUserServices();

	UserServices save(int rid, int cid, String reviews, String userrequest, Boolean isPayment);

	UserServices delete(int rid, int cid, String reviews, String userrequest, Boolean isPayment);

	String getUserServicesById(int rid);

	String serUserpayment(int rid, Boolean boolean1);

	ServiceProvider save(RegisterServiceProviderPojo serviceProvider);

	UserServices update(String ruid);

	UserServices rejectUserService(String replace);

}
