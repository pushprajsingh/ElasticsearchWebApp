package com.demo.elasticsearch.ElasticsearchWebApp;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.elasticsearch.ESEntities.Task;
import com.demo.elasticsearch.ESService.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplicationController.class)
public class MainApplicationControllerTest {

	@Autowired
	private TaskService taskService;
	
	@Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
	
	
	@Before
    public void before() {
		
		/*elasticsearchTemplate.deleteIndex(Task.class);
       	elasticsearchTemplate.createIndex(Task.class);
        elasticsearchTemplate.putMapping(Task.class);
        elasticsearchTemplate.refresh(Task.class);
       	*/
    }
	
	
	@Test
    public void testSave() throws Exception {
    	for(int i=100;i<120;i++){
    	Task task=new Task();
		task.setTaskId(String.format("%d", i));
		task.setTaskAssignedToRole("Test Role");
		task.setTaskDueDate("2015/12/12");
		task.setTaskHealthGoal("Admitted");
		task.setTaskStatus("Diagnosis");
		task.setTaskSubStatus("Pathalogy");
		task.setTaskTitle("Diabatic");
    	taskService.saveTask(task);
    	}
    }
    
}
