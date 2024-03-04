package com.wjd.sisfiado.mappers;

import com.wjd.sisfiado.domain.Role;
import com.wjd.sisfiado.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role roleDtoForRoleEntity(final RoleDto roleDto){
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setAuthority(roleDto.getAuthority());
        return role;
    }
}
