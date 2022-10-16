package com.yash.serviceprovider.controller;

import java.util.ArrayList;
import java.util.List;

import com.yash.serviceprovider.entity.Address;
import com.yash.serviceprovider.entity.Categories;
import com.yash.serviceprovider.entity.Feedback;
import com.yash.serviceprovider.entity.Registration;
import com.yash.serviceprovider.entity.ServiceProvider;
import com.yash.serviceprovider.entity.UserServices;
import com.yash.serviceprovider.pojo.ConfirmPassword;
import com.yash.serviceprovider.pojo.FeedbackPojo;
import com.yash.serviceprovider.pojo.GetUserServicePojo;
import com.yash.serviceprovider.pojo.Login;
import com.yash.serviceprovider.pojo.PendingUserServices;
import com.yash.serviceprovider.pojo.RegisterServiceProviderPojo;
import com.yash.serviceprovider.pojo.ServiceProviderPojo;
import com.yash.serviceprovider.pojo.UserServicePojo;
import com.yash.serviceprovider.service.ServiceProviderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class ServiceProviderController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Autowired
	ServiceProviderService serviceProviderService;

	// User Registraion Endpoint
	@PostMapping("/registration")
	public String regerstrationService(@RequestBody() Registration registration) {
		String respnose = null;

		LOGGER.info(registration.toString());
		if (registration.getPassword().equals(registration.getConfirmpassword())) {
			Registration rdata = serviceProviderService.save(registration);
			respnose = "User Registration Succesful";
		} else {
			respnose = "Password and confirm password are not matching";
		}

		return respnose;
	}

	// Edit Profile Endpoint
	@PostMapping("/editprofile")
	public String editProfile(@RequestBody() Registration registration) {
		String respnose = null;
		LOGGER.info(registration.toString());
		Registration data = serviceProviderService.getUserByEmail(registration.getEmailid());
		if (data != null) {
			data.setFirstname(registration.getFirstname());
			data.setLastname(registration.getLastname());
			data.setMobileno(registration.getMobileno());
			Registration rdata = serviceProviderService.save(data);
			respnose = "User Profile Updated";
		} else {
			respnose = "Failed to Edit Profile";
		}

		return respnose;
	}

	// Login User Endpoint
	@PostMapping("/login")
	public Registration loginService(@RequestBody() Login login) {
		String response = null;
		LOGGER.info("In login" + login);
		Registration rdata = serviceProviderService.getLoginDetails(login.getEmailid());
		LOGGER.info(rdata.toString());
		if (rdata != null) {
			if (rdata.getPassword().equals(login.getPassword()) && rdata.getUsertype().equals("User")) {
				LOGGER.info("in password");
				return rdata;
			} else {
				response = "Password does not match";
			}
		} else {
			response = "Email Id Does not exist";
		}
		return null;
	}

	// Admin Login Endpoint
	@PostMapping("/adminlogin")
	public Registration adminLoginService(@RequestBody() Login login) {
		String response = null;
		LOGGER.info("In login" + login);
		Registration rdata = serviceProviderService.getLoginDetails(login.getEmailid());
		LOGGER.info(rdata.toString());
		if (rdata != null) {
			if (rdata.getPassword().equals(login.getPassword()) && rdata.getUsertype().equals("Admin")) {
				LOGGER.info("in password" + rdata.getUsertype());
				return rdata;
			} else {
				response = "Password does not match";
			}
		} else {
			response = "Email Id Does not exist";
		}
		return null;
	}

	// Service Provider Registration Endpoint
	@PostMapping("/registerserviceprovider")
	public String registerServiceProvider(@RequestBody() RegisterServiceProviderPojo serviceProvider) {
		String respnose = null;
//		Registration rr = new Registration();
//		rr.setRid(1);
//		serviceProvider.setFkregistrationid(rr);
		LOGGER.info(serviceProvider.toString());
		ServiceProvider serviceProviderRes = serviceProviderService.save(serviceProvider);
		if (serviceProviderRes != null) {
			respnose = serviceProviderRes.getSid() + "";
		} else {
			respnose = "Failed to add service provider, Please try again.";
		}
		return respnose;
	}

	// Endpoint for saving Address for Category
	@PostMapping("/saveCategoryAddress")
	public String saveCategoryLocation(@RequestBody() Address address) {
		String respnose = null;
//		Registration rr = new Registration();
//		rr.setRid(1);
//		serviceProvider.setFkregistrationid(rr);

		LOGGER.info(address.toString());
		Address addressResp = serviceProviderService.save(address);
		if (addressResp != null) {
			respnose = addressResp.getAid() + "";
		} else {
			respnose = "Failed to add service provider Location, Please try again.";
		}
		return respnose;
	}

	// Endpoint for Saving Category
	@PostMapping("/saveCategory")
	public String saveCategory(@RequestBody() Categories categories) {
		String respnose = null;
//		Registration rr = new Registration();
//		rr.setRid(1);
//		serviceProvider.setFkregistrationid(rr);

		LOGGER.info(categories.toString());
		Categories categoriesResp = serviceProviderService.save(categories);
		if (categoriesResp != null) {
			respnose = categoriesResp.getCid() + "";
		} else {
			respnose = "Failed to add service provider Category, Please try again.";
		}
		return respnose;
	}

	// Endpoint for Fetching Service Provider Details
	@GetMapping("/getServiceProviders")
	public List<ServiceProvider> getServiceProviders() {
		String response = null;
		List<ServiceProvider> serviceProviderResp = serviceProviderService.getServiceProviders();
		// LOGGER.info(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return serviceProviderResp;

	}

	// Endpoint for Fetching service provider Categories
	@PostMapping("/getServiceProvidersCategories")
	public List<Categories> getServiceProvidersCategories(@RequestBody() ServiceProviderPojo serviceProvider) {
		String response = null;
		LOGGER.info(serviceProvider.toString());
		List<Categories> serviceProviderCategoryResp = serviceProviderService
				.getServiceProvidersCategories(serviceProvider);
		// LOGGER.info(serviceProviderCategoryResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return serviceProviderCategoryResp;

	}

//	Endpoint for fetching all locationa
	@GetMapping("/getAddress")
	public List<Address> getAddress() {
		String response = null;
		List<Address> addressResp = serviceProviderService.getAddress();
		// LOGGER.info(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return addressResp;

	}

	// Endpoint for saving user services
	@PostMapping("/saveUserService")
	public String saveUserService(@RequestBody() UserServicePojo userServices) {
		String respnose = null;
		LOGGER.info(userServices.toString());

		UserServices userServicesResp = serviceProviderService.save(userServices.getRid(), userServices.getCid(),
				userServices.getReviews(), userServices.getUserrequest(), userServices.getIsPayment());
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Failed to add service, Please try again.";
		}
		return respnose;
	}

// Endpoint for deleting user services
	@PostMapping("/deleteuserservice")
	public String deleteUserService(@RequestBody() UserServicePojo userServices) {
		String respnose = null;
		LOGGER.info("In deltete:" + userServices);

		UserServices userServicesResp = serviceProviderService.delete(userServices.getRid(), userServices.getCid(),
				userServices.getReviews(), userServices.getUserrequest(), userServices.getIsPayment());
//		if (userServicesResp != null) {
//			respnose = userServicesResp.getUid() + "";
//		} else {
		respnose = "Record Removed Succesfully.";
//		}
		return respnose;
	}

	// Endpoint for fetching user services
	@GetMapping("/getUserServices")
	public List<PendingUserServices> getUserServices() {
		String response = null;
		LOGGER.info("In user services");
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

		LOGGER.info(userServicesResp.toString());
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return pusl;

	}

	// Endpoint ofr getting user services by user id
	@PostMapping("/getUserServicesbyid")
	public String getUserServiceById(@RequestBody UserServicePojo userServicePojo) {
		String response = null;
		String userServicesResp = serviceProviderService.getUserServicesById(userServicePojo.getRid());
		// LOGGER.info(serviceProviderResp);
//		if (serviceProviderResp != null) {
//			return serviceProviderResp;
//		}
		return userServicesResp;

	}

	// Endpoint for saving user payment details
	@PostMapping("/serUserpayment")
	public String serUserpayment(@RequestBody UserServicePojo userServicePojo) {
		String response = null;
		LOGGER.info(userServicePojo.toString());
		String userServicesResp = serviceProviderService.serUserpayment(userServicePojo.getRid(),
				userServicePojo.getIsPayment());
		// LOGGER.info(serviceProviderResp);
		return null;

	}

	// Endpoint for update user services
	@PostMapping("/updateuserservice")
	public String updateUserService(@RequestBody String ruid) {
		String respnose = null;
		LOGGER.info("In deltete:" + ruid);

		UserServices userServicesResp = serviceProviderService.update(ruid.replace("=", ""));
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Record Updated Succesfully.";

		}
		return respnose;
	}

	// Endpoint for rejecting user services
	@PostMapping("/rejectuserservice")
	public String rejectUserService(@RequestBody String ruid) {
		String respnose = null;
		LOGGER.info("In deltete:" + ruid);

		UserServices userServicesResp = serviceProviderService.rejectUserService(ruid.replace("=", ""));
		if (userServicesResp != null) {
			respnose = userServicesResp.getUid() + "";
		} else {
			respnose = "Record Removed Succesfully.";

		}
		return respnose;
	}

	// Endpoing for change password
	@PostMapping("/confirmpassword")
	public String confirmPassword(@RequestBody ConfirmPassword confirmpassword) throws Exception {
		String respnose = null;
		Registration userdetails = serviceProviderService.confirmPassword(confirmpassword);
		LOGGER.info(userdetails.toString());
		return respnose;
	}

	// Endpoint for saving user feedback
	@PostMapping("/feedback")
	public String saveFedback(@RequestBody FeedbackPojo feedback) throws Exception {
		String respnose = null;
		LOGGER.info(feedback.toString());
		Feedback feedbackResp = serviceProviderService.saveFeedback(feedback);
		// LOGGER.info(userdetails);
		if (feedbackResp != null) {
			respnose = "Success";
		}
		return respnose;
	}

	// Endpoint for getting user services to show on user dashboard
	@PostMapping("/getMyServices")
	public List<GetUserServicePojo> getMyServices(@RequestBody String registrationid) {
		LOGGER.info(registrationid);

		List<GetUserServicePojo> lsp = serviceProviderService.findAllUseServices(registrationid.replace("=", ""));

		return lsp;
	}

}
