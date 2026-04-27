package org.example.spring_samples.respository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.spring_samples.entity.Account;
import org.example.spring_samples.entity.Transactions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Transactions tnx){
        entityManager.persist(tnx);
    }

    public Transactions findById(Long id){
        return entityManager.find(Transactions.class, id);
    }

    public List<Transactions> getTransactions(){
        return entityManager.createQuery(" FROM Transactions ", Transactions.class).getResultList();
    }

public List<Transactions> findByAccount(Account account) {
    return entityManager.createQuery("FROM Transactions t WHERE t.account = :acc",Transactions.class ).setParameter("acc",account).getResultList();
}

    @Transactional
    public  void delete (long id ) {
        Transactions tnx = findById(id);
        if(tnx != null) {
            entityManager.remove(tnx);
        }
    }

}
