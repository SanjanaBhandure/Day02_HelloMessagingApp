package com.greetingapp.repository;

import com.greetingapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @Func :Ability To Save App In Repository
 */

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
