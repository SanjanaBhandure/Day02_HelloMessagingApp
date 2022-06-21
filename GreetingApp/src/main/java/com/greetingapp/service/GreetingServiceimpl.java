package com.greetingapp.service;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
/**
 * @Func :Adding Service Layer
 * @Param:Connecting To Database
 */
@Service
public class GreetingServiceimpl implements GreetingService{
   
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private GreetingRepository greetingRepository;
    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World" : user.toString());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }
    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }
    @Override
    public List<Greeting> getAll() {
        return greetingRepository.findAll();
    }
    @Override
    public Greeting editGreetingById(long id, String name) {
        Greeting greeting = greetingRepository.findById(id).get();
        greeting.setMessage(name);
        greetingRepository.save(greeting);
        return greeting;
    }
    @Override
    public List<Greeting> deleteGreetingById(Long id) {
        greetingRepository.deleteById(id);
        return greetingRepository.findAll();
    }
}
