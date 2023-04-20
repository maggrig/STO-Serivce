package mag.grig.service;

import mag.grig.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findById(Long id);
}
