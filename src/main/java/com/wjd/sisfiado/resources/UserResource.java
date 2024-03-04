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
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(final UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @PostMapping
    public ResponseEntity<UserOutputDto> save(@RequestBody @Valid final UserInputDto userInputDto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userInputDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userService.save(userInputDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutputDto> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserOutputDto> update(@PathVariable final Long id, @RequestBody @Valid final UserInputDto userInputDto) {
        userInputDto.setId(id);
        return ResponseEntity.ok(userService.save(userInputDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable(value = "id") final Long id, @RequestBody Map<String, String> avatarUrl) {
        userService.updateAvatar(avatarUrl.get("avatarUrl"), id);
        return ResponseEntity.noContent().build();
    }
}
