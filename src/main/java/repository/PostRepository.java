package repository;

import model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

// Stub
public class PostRepository {
    private List<Post> posts = new CopyOnWriteArrayList<>();
    private static long countId = 1;

    public List<Post> all() {
        return this.posts;
    }

    public Optional<Post> getById(long id) {
        for (Post post : this.posts) {
            if (post.getId() == id) {
                return Optional.of(post);
            }
        }
        return Optional.empty();
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(countId);
            posts.add(post);
            countId++;
        } else {
            for (Post pst : posts) {
                if (pst.getId() == post.getId()) {
                    posts.set((int) countId, post);
                } else {
                    posts.add(post);
                }
            }
        }
        return post;
    }

    public void removeById(long id) {
        for (Post post : this.posts) {
            if (post.getId() == id) {
                this.posts.remove(post);
            }
        }
    }
}