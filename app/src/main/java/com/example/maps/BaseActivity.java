package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    public List<Task> tasks ;
    private static ActivityManager activityManager;
    private List<Activity> activities ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        tasks = new ArrayList<>();
        activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
    }

    //explore task through command line : adb shell dumpsys activity activities | sed -En -e '/Stack #/p' -e '/Running activities/,/Run #0/p'

    public List<Task> getTasks() {
        List<ActivityManager.RunningTaskInfo> taskInfo =activityManager.getRunningTasks(100);//returns List of RunningTaskInfo - corresponding to tasks - stacks

        for(ActivityManager.RunningTaskInfo info:taskInfo){
            Task task = new Task();
            task.setId(info.id);
            task.setNumOfActivities(info.numActivities);
            tasks.add(task);

        }

//            // Display the root Activity of task-stack
//            stringBuilder.append("TopActivity: "+info.topActivity.getClassName().
//                    toString().replace("lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.","")+"\n");
//
//            // Display the top Activity of task-stack
//            stringBuilder.append("BaseActivity:"+info.baseActivity.getClassName().
//                    toString().replace("lauchmodesdemo.youtube.codetutor.com.activitylauchmodesdemo.","")+"\n");
//            stringBuilder.append("\n\n");
        return tasks ;


    }
}
