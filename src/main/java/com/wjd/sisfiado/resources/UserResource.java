package com.wjd.sisfiado.resources;

import com.wjd.sisfiado.dto.UserInputDto;
import com.wjd.sisfiado.dto.UserOutputDto;
import com.wjd.sisfiado.services.UserService;
import com.wjd.sisfiado.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(final UserServiceImpl userServiceImpl){
        this.userService = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UserOutputDto> save(@RequestBody @Valid final UserInputDto userInputDto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userInputDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userService.save(userInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutputDto> findById(@PathVariable final Long id){
        return ResponseEntity.ok(userService.findById(id));
    }
}
