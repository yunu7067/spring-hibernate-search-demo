package io.github.yunu7067.hibernatesearchdemo.post;


import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Service
public class HibernateSearchService {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    public void initialIndexing() throws InterruptedException {
        var searchSession = Search.session(entityManager);
        var indexer = searchSession.massIndexer(Post.class).threadsToLoadObjects(7);

        indexer.startAndWait();
    }

    public SearchResult<Post> searchPost(String keyword) {
        var searchSession = Search.session(entityManager);
        var result = searchSession.search(Post.class)
                .where(f -> f.match()
                        .fields("title", "content")
                        .matching(keyword)
                )
                .fetch(20);
        var totalHitCount = result.total().hitCount();
        var hits = result.hits();

        return result;
    }
}
