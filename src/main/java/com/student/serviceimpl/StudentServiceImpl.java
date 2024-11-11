package com.student.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.been.AuthResponse;
import com.student.been.Role;
import com.student.been.Student;
import com.student.been.UserRoles;
import com.student.constans.AppConstants;
import com.student.exception.ResourcesAlreadyExists;
import com.student.exception.UserNotFoundException;
import com.student.filter.JWTUtils;
import com.student.payload.StudentLogin;
import com.student.payload.StudentRequest;
import com.student.repo.IStudentRepo;
import com.student.service.AuthStudentService;


@Service
public class StudentServiceImpl implements AuthStudentService,UserDetailsService{

	
	@Autowired
	private IStudentRepo studentRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	@Lazy
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTUtils jwtUtils;

	
	
	
	@Override
	public Student createStudent(StudentRequest u, String roleId) {
		
		System.out.println(roleId);
		 boolean isPresent = this.studentRepository.existsByEmailAndDeleted(u.getEmail(), false);
		    if (isPresent) {
		        throw new ResourcesAlreadyExists("Student with this email already exists: " + u.getEmail());
		    }

		    // Create a new user entity from the user request
		    Student user = new Student();
		    user.setEmail(u.getEmail());
		    user.setPassword(passwordEncoder.encode(u.getPassword()));
		    // Set other properties from userRequest to user as needed

		    Set<UserRoles> userRoles = new HashSet<>();
		    UserRoles userRole = new UserRoles();

		    Role role = new Role();
		    switch (roleId) {
		        case "STUDENT":
		            role.setId(1L);
		            
		            break;
		        case "ADIME":
		            role.setId(2L);
		            break;
		        case "EMPLOYEE":
		            role.setId(3L);
		            break;
		        default:
		            throw new IllegalArgumentException("Invalid role ID: " + roleId);
		    }

		    userRole.setRoles(role);
		    userRole.setRoles(role); 
		    userRoles.add(userRole);

		    user.setUserRoles(userRoles);
		
		    Student savedUser = this.studentRepository.save(user);
		    return savedUser;
		}

		
	

	@Override
	public AuthResponse login(StudentLogin authRequest) {
		  this.authenticationManager.authenticate(
		            new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

		    
		    Student u = this.studentRepository.findByEmailAndDeleted(authRequest.getEmail(), false)
		            .orElseThrow(() -> new UserNotFoundException("No such student found with this email: " + authRequest.getEmail()));

		    
		    String token = jwtUtils.generateToken(authRequest.getEmail());

		    AuthResponse response = new AuthResponse();
		    response.setToken(token);

		    return response;
		}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student user = this.studentRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_EMAIL + email));
		Set<UserRoles> userRoles = user.getUserRoles();
		List<SimpleGrantedAuthority> authorities = userRoles.stream()
				.map(ur -> new SimpleGrantedAuthority(ur.getRoles().getTitle())).collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(email, user.getPassword(), authorities);
	}




	@Override
	public Student updateuser(StudentRequest request) {
		Student user = this.studentRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_EMAIL ));
		user.setStudentName(request.getStudentName());
		user.setStudentAddress(request.getStudentAddress());
		Student save = this.studentRepository.save(user);
		
		  return studentRepository.save(save);
	}

	

}
