package com.neosoft.service;

import com.neosoft.model.Holiday;
import com.neosoft.model.Task;
import com.neosoft.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    HolidayService holidayService;
    @Override
    public Task addTask(Task task) {
        int numberofDaysToCompleteTask= task.getNumberofDays() -1;  //for end date should -1 needed

        Calendar cal = Calendar.getInstance();
        cal.setTime(task.getTaskStartDate());
        cal.add(Calendar.DATE,numberofDaysToCompleteTask);
        Date edate1= cal.getTime();

        int weekendcount =saturdaysundaycount(task.getTaskStartDate(), edate1);

        List<Holiday> holidays = this.holidayService.allHoliday();
        int count;
        int holidaycount = 0;
        if(!holidays.isEmpty()) {
            for (int i = 0; i < holidays.size(); i++) {
                System.out.println(holidays.get(i));
                holidays.get(i).getHolidayDate();
                count = holidaycount(task.getTaskStartDate(), edate1, holidays.get(i).getHolidayDate());
                if (count == 1) {
                    holidaycount += 1;
                }
                else {
                }
            }
        }
        int totalDays=(weekendcount+numberofDaysToCompleteTask+holidaycount);

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(task.getTaskStartDate());
        cal1.add(Calendar.DATE,totalDays);
        Date enddate= cal1.getTime();
        task.setTaskEndDate(enddate);
        return   taskRepository.save(task);

    }
    public static int saturdaysundaycount(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int sundays = 0;
        int saturday = 0;

        while (! c1.after(c2)) {
            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ){
                saturday++;
            }
            if(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                sundays++;
            }
            c1.add(Calendar.DATE, 1);
        }
        if(sundays == 0 && saturday == 1) {
            return (saturday + sundays+1);
        }
        else{
            return saturday + sundays;
        }
    }

    public static int holidaycount(Date min, Date max,Date d) {

        Calendar c3 = Calendar.getInstance();
        c3.setTime(d);

        if (c3.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c3.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ){
            return 0;
        }else {

            if (d.after(min) && d.before(max)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public Task updateTask(Task task) {
        return addTask(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> allTask() {
        return taskRepository.findAll();
    }
}
