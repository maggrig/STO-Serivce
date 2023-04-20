package mag.grig.service.impl;

import mag.grig.entity.Post;
import mag.grig.entity.repository.PostRepository;
import mag.grig.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * @return
     */
    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
}
