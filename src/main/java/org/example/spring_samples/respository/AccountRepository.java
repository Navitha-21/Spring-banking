package org.example.spring_samples.respository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.spring_samples.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Account acc) {
         entityManager.persist(acc);
    }

    public Account findById(Long id) {
        return entityManager.find(Account.class, id);
    }

    public List<Account> getAccounts() {
        return entityManager.createQuery(" From Account ", Account.class).getResultList();
    }

    @Transactional
    public void delete(long id) {
        Account account = findById(id);
        if (account != null) {
            entityManager.remove(account);
        }
    }

    @Transactional
    public void deleteWithFailure(long id) {
        Account account = findById(id);
        if (account != null) {
            entityManager.remove(account);
//            throw new RuntimeException();
        }
    }

}