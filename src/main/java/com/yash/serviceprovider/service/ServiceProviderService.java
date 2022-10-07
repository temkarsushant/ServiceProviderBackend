package com.yash.serviceprovider.service;

import java.util.List;

import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.entity.ServiceProvider;
import com.yash.serviceprovider.entity.UserServices;
import com.yash.serviceprovider.pojo.Login;

public interface ServiceProviderService {

	Registration save(Registration rr);

	Registration getLoginDetails(String emailid);

	ServiceProvider save(ServiceProvider serviceProvider);

	Address save(Address address);

	Categories save(Categories categories);

	List<ServiceProvider> getServiceProviders();

	List<Categories> getServiceProvidersCategories(ServiceProvider serviceProvider);

	List<Address> getAddress();

	UserServices save(UserServices userServices);

	List<UserServices> getUserServices();

}
