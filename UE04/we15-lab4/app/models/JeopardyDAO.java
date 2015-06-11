package models;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import play.Logger;
import play.db.jpa.JPA;
import org.hibernate.*;

/**
 * Provides Data Access methods for JPA
 */
public class JeopardyDAO implements IGameDAO {
    public static final JeopardyDAO INSTANCE = new JeopardyDAO();

    private JeopardyDAO() { }
    
    /**
     * Get a given quiz user based on the id
     * @param id
     * @return
     */
    public JeopardyUser findById(long id) {
        return em().find(JeopardyUser.class, id);
    }

    public JeopardyUser findByUserName(String name) {
        if (name != null && !name.isEmpty()) {
            return getByUserName(name);
        } else {
            return null;
        }
    }

    /**
     * Get a given quiz user based on the name
     * @param name
     * @return
     */
    private JeopardyUser getByUserName(String name) {
        String queryStr = "from JeopardyUser where userName = :userName";
        TypedQuery<JeopardyUser> query = em().createQuery(queryStr,
                JeopardyUser.class).setParameter("userName", name);
        List<JeopardyUser> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }


    /**persist
     * Save an entity. Throws an error if an entity with the given id already exists
     * @param entity
     * @return
     */
    @Override
    public void persist(BaseEntity entity) {
        if (entity.getId() == null || findEntity(entity.getId(), entity.getClass()) == null){
            em().persist(entity);
        }
        // TODO: Implement Method
        // throw new  UnsupportedOperationException("Not yet implemented.");
    }


    public void persist(JeopardyUser user){
        if (user.getId() == null || findEntity(user.getId(), user.getClass()) == null){
            if(user.getBirthDate() == null){
                user.setBirthDate(new Date());
            }
            em().persist(user);
        }
    }
    public void persist(Category category){
        if (category.getId() == null || findEntity(category.getId(), category.getClass()) == null){
            em().persist(category);

            List<Question> lst = category.getQuestions();
            for(Question q : lst){
                persist(q);
            }

        }
    }
    public void persist(Question question){
        if (question.getId() == null || findEntity(question.getId(), question.getClass()) == null){
            em().persist(question);

            List<Answer> lst = question.getAnswers();
            for(Answer a : lst){
                persist(a);
            }
        }

    }
/*    public void persist(Answer answer){
        if (answer.getId() == null || findEntity(answer.getId(), answer.getClass()) == null){
            em().persist(answer);
        }
        System.out.println("persist answer");

    }*/


    /**
     * If no entity with the given id exists in the DB, a new entity is stored. If there is already
     * an entity with the given id, the entity is updated
     * @param entity
     * @param <T>
     * @return
     */
    @Override
    public <T extends BaseEntity> T merge(T entity) {
        BaseEntity old =  findEntity(entity.getId(), entity.getClass());
        if (old == null){
            persist(entity);
        } else {
            em().remove(old);
            persist(entity);
        }
        // TODO: Implement Method
        //throw new UnsupportedOperationException("Not yet implemented.");
        return entity;
    }


    /**
     * Get an entity of the given type using the id
     * @param id
     * @param entityClazz
     * @param <T>
     * @return
     */
    @Override
    public <T extends BaseEntity> T findEntity(Long id, Class<T> entityClazz) {
        return em().find(entityClazz,id);
        // TODO: Implement Method
        // throw new UnsupportedOperationException("Not yet implemented.");
    }


    /**
     * Get a list of all entities of a certain type
     *
     * @param entityClazz
     * @param <E>
     * @return
     */
    @Override
    public <E extends BaseEntity> List<E> findEntities(Class<E> entityClazz) {
        String className = entityClazz.getSimpleName();
        String queryStr = "from " + className;
        TypedQuery<E> query = em().createQuery(queryStr, entityClazz);
        List<E> list = query.getResultList();
        if (list.isEmpty()) {
            Logger.error("No elements in list");
            return null;
        } else {
            Logger.info(entityClazz.getSimpleName() + " list has been loaded");
            return list;
        }

        // TODO: Implement Method
        //throw new UnsupportedOperationException("Not yet implemented.");
    }

    /**
     * Get the entity manager
     * @return
     */
    private EntityManager em() {
        return JPA.em();
    }

}
