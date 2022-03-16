package com.example.demo.controller;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/getById/{identity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long identity) {
        return service.getById(identity);
    }


    @PostMapping(value = "/save",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, //for response
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) //for request
    public ResponseEntity<?> save(@RequestBody UserRequestDTO dto) {
        return service.save(dto);
    }

    @PutMapping(value = "/update/{identity}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> update(@RequestBody UserRequestDTO dto, @PathVariable Long identity) {
        return service.update(dto, identity);
    }

    @DeleteMapping(value = "/delete/{identity}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long identity) {
        return service.delete(identity);
    }
}