package repository;

import model.Post;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (Post post : posts) {
            if (post.getId() == id) {
                return Optional.of(post);
            }
        }
        return Optional.empty();
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            posts.add(new Post(countId, post.getContent()));
            countId++;
        } else {
            Post remove = null;
            Post add = null;
            for (Post pst : posts) {
                if (pst.getId() == post.getId()) {
                    remove = pst;
                    add = post;
                } else {
                    posts.add(post);
                }
            }
            posts.remove(remove);
            posts.add(add);
        }
        return post;
    }

    public void removeById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }
}