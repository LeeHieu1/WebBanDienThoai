package com.nhom13.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Book;
import com.nhom13.model.Book_;
import com.nhom13.repository.custom.SearchRepositoryCustom;
import com.nhom13.utility.Page;

@Repository
public class SearchRepositoryCustomImpl implements SearchRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    public List<Book> getSearchBook(String name, String authorName, Long category, Long minPrice, Long maxPrice,
            Page page) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        List<Predicate> filters = new ArrayList<>();

        if (category != null) {
            filters.add(cb.equal(root.get(Book_.category), category));
        }
        if (maxPrice != null) {
            filters.add(cb.lessThanOrEqualTo(root.get(Book_.price), maxPrice));
        }
        if (minPrice != null) {
            filters.add(cb.greaterThanOrEqualTo(root.get(Book_.price), minPrice));
        }
        // if (authorName != null && !authorName.isBlank()) {
        //     filters.add(cb.like(root.get(Book_.authorname), "%" + authorName + "%"));
        // }
        if (page != null) {
            cq.orderBy(QueryUtils.toOrders(page.getSort(), root, cb));
        }

        Predicate filter = cb.and(filters.toArray(new Predicate[0]));

        if (name != null && !name.isBlank()) {
            filter = cb.and(filter, cb.or(cb.like(root.get(Book_.name), "%" + name + "%"),
                    cb.like(root.get(Book_.description), "%" + name + "%"),
                    cb.like(root.get(Book_.authorname), "%" + name + "%")));
        }
        cq.select(root).where(filter);

        TypedQuery<Book> query = em.createQuery(cq);
        if (page != null) {
            query.setFirstResult(page.getPageNumber() * page.getPageSize());
            query.setMaxResults(page.getPageSize());
        }

        return query.getResultList();

    }

    public Long getCountSearchBook(String name, String authorName, Long category, Long minPrice, Long maxPrice) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Book> root = cq.from(Book.class);
        List<Predicate> filters = new ArrayList<>();

        if (category != null) {
            filters.add(cb.equal(root.get(Book_.category), category));
        }
        if (maxPrice != null) {
            filters.add(cb.lessThanOrEqualTo(root.get(Book_.price), maxPrice));
        }
        if (minPrice != null) {
            filters.add(cb.greaterThanOrEqualTo(root.get(Book_.price), minPrice));
        }
        // if (name != null && !name.isBlank()) {
        // filters.add(cb.like(root.get(Book_.name), "%" + name + "%"));
        // }
        if (authorName != null && !authorName.isBlank()) {
            filters.add(cb.like(root.get(Book_.authorname), "%" + authorName + "%"));
        }

        Predicate filter = cb.and(filters.toArray(new Predicate[0]));
        if (name != null && !name.isBlank()) {
            filter = cb.and(filter, cb.or(cb.like(root.get(Book_.name), "%" + name + "%"),
                    cb.like(root.get(Book_.description), "%" + name + "%")));
        }

        cq.select(cb.count(root)).where(filter);
        return em.createQuery(cq).getSingleResult();
    }

}
