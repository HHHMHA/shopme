package org.thekiddos.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.thekiddos.shopmecommon.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
