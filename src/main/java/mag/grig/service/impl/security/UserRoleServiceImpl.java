/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package mag.grig.service.impl.security;

import mag.grig.entity.repository.security.UserRoleRepository;
import mag.grig.service.security.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    UserRoleRepository userRoleRepository;

    /**
     * @param userId
     */
    @Override
    public void deleteById(Long userId) {
        userRoleRepository.deleteById(userId);
    }
}
