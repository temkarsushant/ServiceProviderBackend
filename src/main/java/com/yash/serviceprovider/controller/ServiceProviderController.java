package com.yash.serviceprovider.controller;

import java.util.ArrayList;
import java.util.List;

import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.entity.ServiceProvider;
import com.yash.serviceprovider.entity.UserServices;
import com.yash.serviceprovider.pojo.Login;
import com.yash.serviceprovider.pojo.PendingUserServices;
import com.yash.serviceprovider.pojo.RegisterServiceProviderPojo;
import com.yash.serviceprovider.pojo.ServiceProviderPojo;
import com.yash.serviceprovider.pojo.UserServicePojo;
import com.yash.serviceprovider.service.ServiceProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class ServiceProviderController {

	@Autowired
	ServiceProviderService serviceProviderService;

	@PostMapping("/registration")
	public String regerstrationService(@RequestBody() Registration registration) {
		String respnose = null;
		System.out.println(registration);
		if (registration.getPassword().equals(registration.getConfirmpassword())) {
			Registration rdata = serviceProviderService.save(registration);
			respnose = "User Registration Succesful";
		} else {
			respnose = "Password and confirm password are not matching";
		}

		return respnose;
	}

	@PostMapping("/login")
	public Registration loginService(@RequestBody() Login login) {
		String response = null;
		System.out.println("In login" + login);
		Registration rdata = serviceProviderService.getLoginDetails(login.getEmailid());
		System.out.println(rdata);
		if (rdata != null) {
			if (rdata.getPassword().equals(login.getPassword())) {
				System.out.println("in password");
				return rdata;
			} else {
				response = "Password does not match";
			}
		} else {
			response = "Email Id Does not exist";
		}
		return null;
	}

	@PostMapping("/adminlogin")
	public Registration adminLoginService(@RequestBody() Login login) {
		String response = null;
		System.out.println("In login" + login);
		Registration rdata = serviceProviderService.getLoginDetails(login.getEmailid());
		System.out.println(rdata);
		if (rdata != null) {
			if (rdata.getPassword().equals(login.getPassword()) && rdata.getUsertype().equals("Admin")) {
				System.out.println("in password" + rdata.getUsertype());
				return rdata;
			} else {
				response = "Password does not match";
			}
		} else {
			response = "Email Id Does not exist";
		}
		return null;
	}

	@PostMapping("/registerserviceprovider")
	public String registerServiceProvider(@RequestBody() RegisterServiceProviderPojo serviceProvider) {
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
	@PostMapping("/getServiceProvidersCategories")
	public List<Categories> getServiceProvidersCategories(@RequestBody() ServiceProviderPojo serviceProvider) {
		String response = null;
		System.out.println(serviceProvider);
		List<Categories> serviceProviderCategoryResp = serviceProviderService
				.getServiceProvidersCategories(serviceProvider);
		// System.out.println(serviceProviderCategoryResp);
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
	public String saveUserService(@RequestBody() UserServicePojo userServices) {
		String respnose = null;
		System.out.println(userServices);

		UserServices userServicesResp = serviceProviderService.save(userServices.getRid(), userServices.getCid(),
				userServices.getReviews(), userServices.getUserrequest(), userServices.getIsPayment());
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Failed to add service, Please try again.";
		}
		return respnose;
	}

	@PostMapping("/deleteuserservice")
	public String deleteUserService(@RequestBody() UserServicePojo userServices) {
		String respnose = null;
		System.out.println("In deltete:" + userServices);

		UserServices userServicesResp = serviceProviderService.delete(userServices.getRid(), userServices.getCid(),
				userServices.getReviews(), userServices.getUserrequest(), userServices.getIsPayment());
//		if (userServicesResp != null) {
//			respnose = userServicesResp.getUid() + "";
//		} else {
		respnose = "Record Removed Succesfully.";
//		}
		return respnose;
	}

	@GetMapping("/getUserServices")
	public List<PendingUserServices> getUserServices() {
		String response = null;
		System.out.println("In user services");
		List<UserServices> userServicesResp = serviceProviderService.getUserServices();
		List<PendingUserServices> pusl = new ArrayList<>();

		for (UserServices us : userServicesResp) {
			PendingUserServices pus = new PendingUserServices();
			pus.setUsid(us.getUid());
			pus.setEmialid(us.getFkregistrationuserid().getEmailid());
			pus.setFirstname(us.getFkregistrationuserid().getFirstname());
			pus.setLastname(us.getFkregistrationuserid().getLastname());
			pus.setIspayment(us.getIsPayment().toString());
			pus.setMobileno(us.getFkregistrationuserid().getMobileno());
			pus.setUserrequest(us.getUserrequest());
			pusl.add(pus);
		}

		System.out.println(userServicesResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return pusl;

	}

	@PostMapping("/getUserServicesbyid")
	public String getUserServiceById(@RequestBody UserServicePojo userServicePojo) {
		String response = null;
		String userServicesResp = serviceProviderService.getUserServicesById(userServicePojo.getRid());
		// System.out.println(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return userServicesResp;

	}

	@PostMapping("/serUserpayment")
	public String serUserpayment(@RequestBody UserServicePojo userServicePojo) {
		String response = null;
		System.out.println(userServicePojo);
		String userServicesResp = serviceProviderService.serUserpayment(userServicePojo.getRid(),
				userServicePojo.getIsPayment());
		// System.out.println(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return null;

	}

	@PostMapping("/updateuserservice")
	public String updateUserService(@RequestBody String ruid) {
		String respnose = null;
		System.out.println("In deltete:" + ruid);

		UserServices userServicesResp = serviceProviderService.update(ruid.replace("=",""));
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Record Removed Succesfully.";
//		}
			
		}
		return respnose;
	}

	@PostMapping("/rejectuserservice")
	public String rejectUserService(@RequestBody String ruid) {
		String respnose = null;
		System.out.println("In deltete:" + ruid);

		UserServices userServicesResp = serviceProviderService.rejectUserService(ruid.replace("=",""));
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Record Removed Succesfully.";
//		}
			
		}
		return respnose;
	}

	
}
