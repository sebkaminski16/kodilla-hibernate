package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskDao extends CrudRepository<Task, Integer> {
    public List<Task> findByDuration(int duration);

    @Query
    public List<Task> retrieveLongTasks();

    @Query
    public List<Task> retrieveShortTasks();

    @Query(nativeQuery = true)
    public List<Task> retrieveTasksWithEnoughTime();

    @Query
    public List<Task> retrieveTasksWithDurationLongerThan(@Param("DURATION") int duration);
}
