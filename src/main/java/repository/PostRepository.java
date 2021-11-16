package repository;

import exception.NotFoundException;
import model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository {
    private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
    private static AtomicLong countId = new AtomicLong(1);

    public List<Post> all() {
        return new ArrayList<>(posts.values());
    }

    public Optional<Post> getById(long id) {
        Post post = findPostById(id);
        return post != null ? Optional.of(post) : Optional.empty();
    }

    public Post save(Post post) {
        synchronized (post) {
            if (post.getId() == 0) {
                post.setId(countId.incrementAndGet());
                posts.put(post.getId(), post);
                return post;
            }

            Post p = findPostById(post.getId());
            if (p != null) {
                posts.put(post.getId(), post);
            }
            return p;
        }
    }

    public void removeById(long id) {
        posts.remove(id, findPostById(id));
    }

    private Post findPostById(long id) {
        if (posts.containsKey(id)) {
            return posts.get(id);
        } else throw new NotFoundException("Post not found");
    }
}