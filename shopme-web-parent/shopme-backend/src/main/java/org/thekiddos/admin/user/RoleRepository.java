package org.thekiddos.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.thekiddos.shopmecommon.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
