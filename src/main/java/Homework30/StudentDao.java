package Homework30;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import java.util.List;

public class StudentDao implements GenericDao<Student, Long> {

    private final EntityManager em = Persistence.createEntityManagerFactory("hillel-persistence-unit").createEntityManager();

    @Override
    public void save(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public Student findByEmail(String email) {
        return em.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student update(Student student) {
        em.getTransaction().begin();
        Student updatedStudent = em.merge(student);
        em.getTransaction().commit();
        return updatedStudent;
    }

    @Override
    public boolean deleteById(Long id) {
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
            em.getTransaction().commit();
            return true;
        }
        em.getTransaction().rollback();
        return false;
    }
}
