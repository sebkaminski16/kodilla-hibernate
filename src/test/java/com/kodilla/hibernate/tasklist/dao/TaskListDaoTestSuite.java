package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "Lista number 1";
    private static final String DESCRIPTION = "Opis listy numer 1";

    @Test
    public void testFindByListName(){
        //arrange
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //act
        List<TaskList> taskLists = taskListDao.findByListName(listName);

        //assert
        Assertions.assertEquals(1, taskLists.size());
        Assertions.assertEquals(listName, taskLists.getFirst().getListName());

        //clean
        taskListDao.deleteById(taskLists.getFirst().getId());
    }
}
