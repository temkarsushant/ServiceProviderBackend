package com.yash.serviceprovider.controller;

import java.util.List;

import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.entity.ServiceProvider;
import com.yash.serviceprovider.entity.UserServices;
import com.yash.serviceprovider.pojo.Login;
import com.yash.serviceprovider.service.ServiceProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {

	@Autowired
	ServiceProviderService serviceProviderService;

	@PostMapping("/registration")
	public String regerstrationService(@RequestBody() Registration registration) {
		String respnose = null;
		if (registration.getPassword().equals(registration.getConfirmpassword())) {
			Registration rdata = serviceProviderService.save(registration);
			respnose = "User Registration Succesful";
		} else {
			respnose = "Password and confirm password are not matching";
		}

		return respnose;
	}

	@GetMapping("/login")
	public Registration loginService(@RequestBody() Login login) {
		String response = null;
		Registration rdata = serviceProviderService.getLoginDetails(login.getEmailId());
		System.out.println(rdata);
		if (rdata != null) {
			if (rdata.getPassword().equals(login.getPassword())) {
				response = "Login Succsuful";
			} else {
				response = "Password does not match";
			}
		} else {
			response = "Email Id Does not exist";
		}
		return rdata;
	}

	@PostMapping("/registerserviceprovider")
	public String registerServiceProvider(@RequestBody() ServiceProvider serviceProvider) {
		String respnose = null;
//		Registration rr = new Registration();
//		rr.setRid(1);
//		serviceProvider.setFkregistrationid(rr);
		System.out.println(serviceProvider);
		ServiceProvider serviceProviderRes = serviceProviderService.save(serviceProvider);
		if (serviceProviderRes != null) {
			respnose = serviceProviderRes.getSid() + "";
		} else {
			respnose = "Failed to add service provider, Please try again.";
		}
		return respnose;
	}

	@PostMapping("/saveCategoryAddress")
	public String saveCategoryLocation(@RequestBody() Address address) {
		String respnose = null;
//		Registration rr = new Registration();
//		rr.setRid(1);
//		serviceProvider.setFkregistrationid(rr);

		System.out.println(address);
		Address addressResp = serviceProviderService.save(address);
		if (addressResp != null) {
			respnose = addressResp.getAid() + "";
		} else {
			respnose = "Failed to add service provider Location, Please try again.";
		}
		return respnose;
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@RequestBody() Categories categories) {
		String respnose = null;
//		Registration rr = new Registration();
//		rr.setRid(1);
//		serviceProvider.setFkregistrationid(rr);

		System.out.println(categories);
		Categories categoriesResp = serviceProviderService.save(categories);
		if (categoriesResp != null) {
			respnose = categoriesResp.getCid() + "";
		} else {
			respnose = "Failed to add service provider Category, Please try again.";
		}
		return respnose;
	}

	@GetMapping("/getServiceProviders")
	public List<ServiceProvider> getServiceProviders() {
		String response = null;
		List<ServiceProvider> serviceProviderResp = serviceProviderService.getServiceProviders();
		// System.out.println(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return serviceProviderResp;

	}

	// Address also should be come in this methods request
	@GetMapping("/getServiceProvidersCategories")
	public List<Categories> getServiceProvidersCategories(@RequestBody() ServiceProvider serviceProvider) {
		String response = null;
		List<Categories> serviceProviderCategoryResp = serviceProviderService
				.getServiceProvidersCategories(serviceProvider);
		// System.out.println(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return serviceProviderCategoryResp;

	}

	@GetMapping("/getAddress")
	public List<Address> getAddress() {
		String response = null;
		List<Address> addressResp = serviceProviderService.getAddress();
		// System.out.println(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return addressResp;

	}

	@PostMapping("/saveUserService")
	public String saveUserService(@RequestBody() UserServices userServices) {
		String respnose = null;
		System.out.println(userServices);
		UserServices userServicesResp = serviceProviderService.save(userServices);
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Failed to add User service, Please try again.";
		}
		return respnose;
	}

	@GetMapping("/getUserServices")
	public List<UserServices> getUserServices() {
		String response = null;
		List<UserServices> userServicesResp = serviceProviderService.getUserServices();
		// System.out.println(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return userServicesResp;

	}

}
