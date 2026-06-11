package com.example.neurofleetbackkendD.service;
import com.example.neurofleetbackkendD.model.User;
import com.example.neurofleetbackkendD.model.enums.UserRole;
import com.example.neurofleetbackkendD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User register(User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new IllegalArgumentException("Username is required");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }
        if (user.getFullName() == null || user.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("Full name is required");
        }

        if (user.getRole() == null) {
            user.setRole(UserRole.CUSTOMER);
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public Optional<User> authenticate(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public List<User> getActiveDrivers() {
        return userRepository.findByRole(UserRole.DRIVER).stream()
            .filter(User::getActive)
            .collect(Collectors.toList());
    }

    // Needed by DriverController (admin assign-cities / driver utilities)
    public List<User> getUsersByRole(UserRole role) {
        return userRepository.findByRole(role);
    }

    // Needed by DriverController (admin assigns cities to drivers)
    public User updateUser(Long id, User updatedUser) {
        User existing = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

        // Update allowed fields (avoid overwriting immutable identity)
        if (updatedUser.getFullName() != null) existing.setFullName(updatedUser.getFullName());
        if (updatedUser.getEmail() != null) existing.setEmail(updatedUser.getEmail());
        if (updatedUser.getPhoneNumber() != null) existing.setPhoneNumber(updatedUser.getPhoneNumber());
        if (updatedUser.getAddress() != null) existing.setAddress(updatedUser.getAddress());
        if (updatedUser.getLicenseNumber() != null) existing.setLicenseNumber(updatedUser.getLicenseNumber());
        if (updatedUser.getProfilePicture() != null) existing.setProfilePicture(updatedUser.getProfilePicture());
        if (updatedUser.getAssignedCity() != null) existing.setAssignedCity(updatedUser.getAssignedCity());
        if (updatedUser.getActive() != null) existing.setActive(updatedUser.getActive());
        if (updatedUser.getRole() != null) existing.setRole(updatedUser.getRole());

        // Only update password if provided (and encode it)
        if (updatedUser.getPassword() != null && !updatedUser.getPassword().trim().isEmpty()) {
            existing.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        return userRepository.save(existing);
    }
}
